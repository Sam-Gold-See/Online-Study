package com.study.service.impl;

import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.JwtConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.AdminUserDTO;
import com.study.entity.AdminUser;
import com.study.exception.AccountException;
import com.study.exception.OperationException;
import com.study.mapper.AdminUserMapper;
import com.study.properties.JwtProperties;
import com.study.service.AdminUserService;
import com.study.utils.IdUtil;
import com.study.utils.JwtUtil;
import com.study.vo.AdminUserLoginVO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO
     */
    @Override
    public void add(AdminUserDTO adminUserDTO) {
        // 校验当前管理员账号是否有权限
        Long userId = BaseContext.getCurrentId();
        Integer level = adminUserMapper.checkById(userId);

        if (!Objects.equals(level, AccountConstant.PERMISSION))
            throw new OperationException(MessageConstant.PERMISSION_ERROR);

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDTO, adminUser);
        adminUser.setPassword(DigestUtils.md5DigestAsHex(adminUserDTO.getPassword().getBytes()));

        Long id = IdUtil.generateId(IdConstant.ADMIN_SIGNAL);
        adminUser.setId(id);

        adminUserMapper.insert(adminUser);
    }

    /**
     * B端用户登录
     *
     * @param adminUserDTO B端用户DTO
     */
    @Override
    public AdminUserLoginVO login(AdminUserDTO adminUserDTO) {
        String username = adminUserDTO.getUsername();

        // 根据用户登录账号查询用户数据
        AdminUser adminUserDB = adminUserMapper.getByUsername(username);

        if (adminUserDB == null) {
            // 账号不存在
            throw new AccountException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        if (!Objects.equals(adminUserDB.getStatus(), AccountConstant.ENABLED)) {
            // 账号不存在
            throw new AccountException(MessageConstant.ACCOUNT_LOCKED);
        }

        // 密码加密成暗文，在数据库中密码以暗文形式存储
        String password = adminUserDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        if (!password.equals(adminUserDB.getPassword())) {
            // 密码错误
            throw new AccountException(MessageConstant.PASSWORD_ERROR);
        }

        // 生成Jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstant.ADMIN_ID, adminUserDB.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        AdminUserLoginVO adminUserLoginVO = new AdminUserLoginVO();
        BeanUtils.copyProperties(adminUserDB, adminUserLoginVO);
        adminUserLoginVO.setToken(token);

        return adminUserLoginVO;
    }

    /**
     * B端用户退出
     *
     * @param token jwt令牌
     */
    @Override
    public void logout(String token) {
        try {
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Date expiration = claims.getExpiration();
            long expireTime = (expiration.getTime() - System.currentTimeMillis()) / 1000;

            if (expireTime > 0)
                stringRedisTemplate.opsForValue().set(JwtConstant.BLACKLIST_KEY + token, "", expireTime, TimeUnit.SECONDS);
        } catch (Exception ex) {
            throw new AccountException(MessageConstant.JWT_ERROR);
        }
    }

    /**
     * 设置B端用户登录权限
     *
     * @param adminUserDTO B端用户DTO
     */
    @Override
    public void editStatus(AdminUserDTO adminUserDTO) {
        Long userId = BaseContext.getCurrentId();

        if (userId.equals(adminUserDTO.getId())) {
            throw new OperationException(MessageConstant.INVALID_OPERATION);
        }

        AdminUser adminUserDB = adminUserMapper.getById(userId);

        if (!Objects.equals(adminUserDB.getStatus(), AccountConstant.PERMISSION)) {
            throw new AccountException(MessageConstant.PERMISSION_ERROR);
        }

        adminUserMapper.update(AdminUser.builder()
                .id(adminUserDTO.getId())
                .status(adminUserDTO.getStatus())
                .build());
    }

    /**
     * 设置B端用户修改权限
     *
     * @param adminUserDTO B端用户DTO
     */
    @Override
    public void editLevel(AdminUserDTO adminUserDTO) {
        Long userId = BaseContext.getCurrentId();

        if (userId.equals(adminUserDTO.getId())) {
            throw new OperationException(MessageConstant.INVALID_OPERATION);
        }

        AdminUser adminUserDB = adminUserMapper.getById(userId);

        if (!Objects.equals(adminUserDB.getLevel(), AccountConstant.PERMISSION)) {
            throw new AccountException(MessageConstant.PERMISSION_ERROR);
        }

        adminUserMapper.update(AdminUser.builder()
                .id(adminUserDTO.getId())
                .level(adminUserDTO.getLevel())
                .build());
    }
}
