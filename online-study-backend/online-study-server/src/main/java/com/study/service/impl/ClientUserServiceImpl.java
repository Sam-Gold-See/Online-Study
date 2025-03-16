package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.JwtClaimsConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.clientuser.*;
import com.study.entity.ClientUser;
import com.study.exception.AccountNotFoundException;
import com.study.exception.AccountStatusException;
import com.study.exception.PasswordErrorException;
import com.study.exception.VerificationCodeErrorException;
import com.study.mapper.ClientUserMapper;
import com.study.properties.JwtProperties;
import com.study.result.PageResult;
import com.study.service.ClientUserService;
import com.study.utils.CodeUtils;
import com.study.utils.EmailUtils;
import com.study.utils.IdGeneratorUtil;
import com.study.utils.JwtUtil;
import com.study.vo.ClientUserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO对象
     */
    @Override
    public void add(ClientUserRegistDTO clientUserRegistDTO) {
        //  获取用户邮箱和验证码
        String email = clientUserRegistDTO.getEmail();
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        String verificationCode = clientUserRegistDTO.getVerificationCode();
        verificationCode = CodeUtils.upperLetters(verificationCode);

        //  验证码比对
        if (verificationCodeRedis == null || !Objects.equals(verificationCode, verificationCodeRedis)) {
            throw new VerificationCodeErrorException(MessageConstant.VERIFICATION_CODE_ERROR);
        }

        //  验证码正确，删除 Redis 中的验证码
        stringRedisTemplate.delete(email);

        //  复制数据并加密密码
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserRegistDTO, clientUser);
        clientUser.setPassword(DigestUtils.md5DigestAsHex(clientUserRegistDTO.getPassword().getBytes()));

        //  生成唯一 ID 并赋值
        clientUser.setId(IdGeneratorUtil.generateId(IdConstant.CLIENT_SIGNAL));

        //  插入数据库
        clientUserMapper.insert(clientUser);
    }

    /**
     * 用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO对象
     * @return ClientUserLoginVO C端用户登录VO对象
     */
    @Override
    public ClientUserLoginVO login(ClientUserLoginDTO clientUserLoginDTO) {
        String email = clientUserLoginDTO.getEmail();

        // 根据用户邮箱号、登录账号查询用户库数据
        ClientUser clientUserDB = clientUserMapper.getByEmail(email);
        if (clientUserDB == null)
            // 账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);

        if (!Objects.equals(clientUserDB.getStatus(), AccountConstant.ENABLED))
            // 账号被封禁无法登录
            throw new AccountStatusException(MessageConstant.ACCOUNT_LOCKED);

        String password = clientUserLoginDTO.getPassword();
        // 密码加密成暗文，在数据库中密码以暗文形式存储
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        if (!password.equals(clientUserDB.getPassword()))
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);

        // 生成JWT令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.CLIENT_ID, clientUserDB.getId());
        String authentication = JwtUtil.createJWT(
                jwtProperties.getClientSecretKey(),
                jwtProperties.getClientTtl(),
                claims);

        return ClientUserLoginVO.builder()
                .id(clientUserDB.getId())
                .name(clientUserDB.getName())
                .email(email)
                .authentication(authentication)
                .build();
    }

    /**
     * 发送验证码
     *
     * @param toEmail 目标邮箱
     */
    @Override
    public void sendMsg(String toEmail) {
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(toEmail);
        if (!(verificationCodeRedis == null))
            throw new VerificationCodeErrorException(MessageConstant.VERIFICATION_CODE_REPEAT);

        String verificationCode = UUID.randomUUID().toString().substring(
                AccountConstant.VERIFICATION_CODE_START,
                AccountConstant.VERIFICATION_CODE_LENGTH);
        verificationCode = CodeUtils.upperLetters(verificationCode);
        EmailUtils.sendVerificationCode(toEmail, verificationCode);

        stringRedisTemplate.opsForValue()
                .set(toEmail, verificationCode, AccountConstant.VERIFICATION_CODE_TTL, TimeUnit.MINUTES);
    }

    /**
     * 修改密码
     *
     * @param clientUserEditPasswordDTO C端用户修改密码DTO
     */
    @Override
    public void editPassword(ClientUserEditPasswordDTO clientUserEditPasswordDTO) {
        //  获取用户邮箱和验证码
        String email = clientUserEditPasswordDTO.getEmail();
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        String verificationCode = clientUserEditPasswordDTO.getVerificationCode();
        verificationCode = CodeUtils.upperLetters(verificationCode);

        //  验证码比对
        if (verificationCodeRedis == null || !Objects.equals(verificationCode, verificationCodeRedis)) {
            throw new VerificationCodeErrorException(MessageConstant.VERIFICATION_CODE_ERROR);
        }

        stringRedisTemplate.delete(email);

        String password = clientUserEditPasswordDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        clientUserMapper.update(ClientUser.builder()
                .email(email)
                .password(password)
                .build());
    }

    /**
     * 修改邮箱
     *
     * @param clientUserEditEmailDTO C端用户修改邮箱DTO
     */
    @Override
    public void editEmail(ClientUserEditEmailDTO clientUserEditEmailDTO) {
        //  获取用户新邮箱和验证码
        String newEmail = clientUserEditEmailDTO.getNewEmail();
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(newEmail);
        String verificationCode = clientUserEditEmailDTO.getVerificationCode();
        verificationCode = CodeUtils.upperLetters(verificationCode);

        //  验证码比对
        if (verificationCodeRedis == null || !Objects.equals(verificationCode, verificationCodeRedis)) {
            throw new VerificationCodeErrorException(MessageConstant.VERIFICATION_CODE_ERROR);
        }

        stringRedisTemplate.delete(newEmail);

        Long userId = BaseContext.getCurrentId();
        ClientUser oldClientUser = clientUserMapper.getById(userId);

        if (!(Objects.equals(oldClientUser.getEmail(), clientUserEditEmailDTO.getOldEmail())))
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);

        String password = clientUserEditEmailDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!Objects.equals(oldClientUser.getPassword(), password))
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);

        clientUserMapper.updateEmail(ClientUser.builder()
                .email(newEmail)
                .id(userId)
                .build());
    }

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO对象
     * @return PageResult<AdminUser> ClientUser类的分页查询对象
     */
    @Override
    public PageResult<ClientUser> getClientListPage(ClientUserPageQueryDTO clientUserPageQueryDTO) {
        PageHelper.startPage(clientUserPageQueryDTO.getPage(),clientUserPageQueryDTO.getPageSize());

        Page<ClientUser> page = clientUserMapper.getListPage(clientUserPageQueryDTO);

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    /**
     * 修改个人信息
     *
     * @param clientUserUpdateDTO 用户更新个人信息DTO
     */
    @Override
    public void updateInfo(ClientUserUpdateDTO clientUserUpdateDTO) {
        Long userId = BaseContext.getCurrentId();

        ClientUser clientUser = new ClientUser();
        clientUser.setId(userId);
        BeanUtils.copyProperties(clientUserUpdateDTO, clientUser);

        clientUserMapper.update(clientUser);
    }

    /**
     * 查询个人信息
     *
     * @return ClientUser实体类对象
     */
    @Override
    public ClientUser getInfo() {
        return clientUserMapper.getById(BaseContext.getCurrentId());
    }
}
