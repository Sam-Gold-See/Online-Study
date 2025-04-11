package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.JwtConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.ClientUserDTO;
import com.study.dto.ClientUserPageQueryDTO;
import com.study.entity.ClientUser;
import com.study.exception.AccountException;
import com.study.exception.VerificationException;
import com.study.mapper.ClientUserMapper;
import com.study.properties.JwtProperties;
import com.study.result.PageResult;
import com.study.service.ClientUserService;
import com.study.utils.IdUtil;
import com.study.utils.JwtUtil;
import com.study.vo.ClientUserLoginVO;
import com.study.vo.ClientUserVO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO
     */
    @Override
    public void add(ClientUserDTO clientUserDTO) {
        // 获取用户邮箱和验证码
        String email = clientUserDTO.getEmail();

        ClientUser clientUserDB = clientUserMapper.getByEmail(email);
        if (clientUserDB != null) {
            // 账号已存在
            throw new AccountException(MessageConstant.ACCOUNT_ALREADY_EXIST);
        }

        // 检验验证码
        checkVerificationCode(email);

        // 复制数据
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserDTO, clientUser);

        // 加密密码
        clientUser.setPassword(DigestUtils.md5DigestAsHex(clientUserDTO.getPassword().getBytes()));

        // 生成唯一ID并赋值
        clientUser.setId(IdUtil.generateId(IdConstant.CLIENT_SIGNAL));

        // 插入数据库
        clientUserMapper.insert(clientUser);
    }

    /**
     * C端用户登录
     *
     * @param clientUserDTO C端用户DTO
     */
    @Override
    public ClientUserLoginVO login(ClientUserDTO clientUserDTO) {
        String email = clientUserDTO.getEmail();

        // 根据用户邮箱号/登录账号查询用户库数据
        ClientUser clientUserDB = clientUserMapper.getByEmail(email);
        if (clientUserDB == null) {
            // 账号不存在
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        if (!Objects.equals(clientUserDB.getStatus(), AccountConstant.ENABLED)) {
            // 账号被封禁无法登陆
            throw new AccountException(MessageConstant.ACCOUNT_LOCKED);
        }

        // 密码加密
        String password = DigestUtils.md5DigestAsHex(clientUserDTO.getPassword().getBytes());

        if (!password.equals(clientUserDB.getPassword())) {
            throw new AccountException(MessageConstant.PASSWORD_ERROR);
        }

        // 生成Jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstant.CLIENT_ID, clientUserDB.getId());
        claims.put(JwtConstant.CLIENT_EMAIL, email);
        String authentication = JwtUtil.createJWT(
                jwtProperties.getClientSecretKey(),
                jwtProperties.getClientTtl(),
                claims
        );

        stringRedisTemplate.opsForValue().set(JwtConstant.AUTHENTICATION_LIST + email, authentication, jwtProperties.getClientTtl(), TimeUnit.MILLISECONDS);

        return ClientUserLoginVO.builder()
                .id(clientUserDB.getId())
                .name(clientUserDB.getName())
                .email(email)
                .avatar(clientUserDB.getAvatar())
                .authentication(authentication)
                .build();
    }

    /**
     * C端用户重置密码
     *
     * @param clientUserDTO C端用户DTO
     */
    @Override
    public void editPassword(ClientUserDTO clientUserDTO) {
        // 获取用户邮箱和验证码
        String email = clientUserDTO.getEmail();
        checkVerificationCode(email);

        String password = clientUserDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        Long id = clientUserMapper.getByEmail(email).getId();

        clientUserMapper.update(ClientUser.builder()
                .id(id)
                .password(password)
                .build());

        stringRedisTemplate.delete(JwtConstant.AUTHENTICATION_LIST + email);
    }

    /**
     * C端用户重置邮箱
     *
     * @param clientUserDTO C端用户DTO
     */
    @Override
    public void editEmail(ClientUserDTO clientUserDTO) {
        //  获取用户新邮箱和验证码
        String newEmail = clientUserDTO.getEmail();
        String oldEmail = clientUserDTO.getOldEmail();

        Long userId = BaseContext.getCurrentId();
        ClientUser clientUserDB = clientUserMapper.getById(userId);

        // 检查目前账号的邮箱是否为数据库中邮箱（旧邮箱）
        if (!(Objects.equals(clientUserDB.getEmail(), oldEmail))) {
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 检验验证码
        checkVerificationCode(newEmail);
        checkVerificationCode(oldEmail);

        clientUserMapper.update(ClientUser.builder()
                .id(userId)
                .email(newEmail)
                .build());
    }

    /**
     * C端用户修改个人信息
     *
     * @param clientUserDTO C端用户DTO
     */
    @Override
    public void editInfo(ClientUserDTO clientUserDTO) {
        Long userId = BaseContext.getCurrentId();

        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserDTO, clientUser);
        clientUser.setId(userId);

        clientUserMapper.update(clientUser);
    }

    /**
     * C端用户退出
     *
     * @param authentication jwt令牌
     */
    @Override
    public void logout(String authentication) {
        try {
            Claims claims = JwtUtil.parseJWT(jwtProperties.getClientSecretKey(), authentication);
            String email = claims.get(JwtConstant.CLIENT_EMAIL).toString();

            stringRedisTemplate.delete(JwtConstant.AUTHENTICATION_LIST + email);
        } catch (Exception ex) {
            throw new AccountException(MessageConstant.JWT_ERROR);
        }
    }

    /**
     * 设置C端用户登录权限
     *
     * @param clientUserDTO 用户管理DTO对象
     */
    @Override
    public void editStatus(ClientUserDTO clientUserDTO) {
        ClientUser clientUser = clientUserMapper.getById(clientUserDTO.getId());
        if (clientUser == null) {
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        stringRedisTemplate.delete(JwtConstant.AUTHENTICATION_LIST + clientUserDTO.getEmail());

        clientUserMapper.update(ClientUser.builder()
                .id(clientUserDTO.getId())
                .status(clientUserDTO.getStatus())
                .build());
    }

    /**
     * 查询C端用户信息
     *
     * @param id C端用户id
     */
    @Override
    public ClientUserVO getInfo(Long id) {
        ClientUser clientUserDB = clientUserMapper.getById(id);

        if (clientUserDB == null) {
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        ClientUserVO clientUserVO = new ClientUserVO();
        BeanUtils.copyProperties(clientUserDB, clientUserVO);

        return clientUserVO;
    }

    /**
     * 设置C端用户信息
     *
     * @param clientUserDTO C端用户DTO对象
     */
    @Override
    public void setInfo(ClientUserDTO clientUserDTO) {
        Long id = clientUserDTO.getId();

        ClientUser clientUserDB = clientUserMapper.getById(id);

        if (clientUserDB == null) {
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserDTO, clientUser);

        clientUserMapper.update(clientUser);
    }

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO
     */
    @Override
    public PageResult<ClientUserVO> query(ClientUserPageQueryDTO clientUserPageQueryDTO) {
        PageHelper.startPage(clientUserPageQueryDTO.getPage(), clientUserPageQueryDTO.getPageSize());

        Page<ClientUserVO> page = clientUserMapper.query(clientUserPageQueryDTO);

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    private void checkVerificationCode(String email) {
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(AccountConstant.REDIS_KEY + email);

        // 验证码比对
        if (verificationCodeRedis == null || !Objects.equals(verificationCodeRedis, AccountConstant.PERMISSION.toString())) {
            throw new VerificationException(MessageConstant.PERMISSION_ERROR);
        }

        // 验证码正确，删除 Redis 中的验证码
        stringRedisTemplate.delete(AccountConstant.REDIS_KEY + email);
    }
}
