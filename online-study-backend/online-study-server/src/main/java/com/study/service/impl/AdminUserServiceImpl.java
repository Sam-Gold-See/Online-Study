package com.study.service.impl;

import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.JwtClaimsConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.AdminUserDTO;
import com.study.entity.AdminUser;
import com.study.exception.AccountException;
import com.study.mapper.AdminUserMapper;
import com.study.properties.JwtProperties;
import com.study.service.AdminUserService;
import com.study.utils.IdUtil;
import com.study.utils.JwtUtil;
import com.study.vo.AdminUserLoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

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
            throw new AccountException(MessageConstant.PERMISSION_ERROR);

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
        claims.put(JwtClaimsConstant.ADMIN_ID, adminUserDB.getId());
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
}
