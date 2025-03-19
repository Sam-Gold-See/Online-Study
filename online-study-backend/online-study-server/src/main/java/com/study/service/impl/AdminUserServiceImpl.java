package com.study.service.impl;

import com.study.constant.AccountConstant;
import com.study.constant.IdConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.AdminUserDTO;
import com.study.entity.AdminUser;
import com.study.exception.AccountException;
import com.study.mapper.AdminUserMapper;
import com.study.service.AdminUserService;
import com.study.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

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

        if(!Objects.equals(level, AccountConstant.PERMISSION))
            throw new AccountException(MessageConstant.PERMISSION_ERROR);

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDTO, adminUser);
        adminUser.setPassword(DigestUtils.md5DigestAsHex(adminUserDTO.getPassword().getBytes()));

        Long id = IdUtil.generateId(IdConstant.ADMIN_SIGNAL);
        adminUser.setId(id);

        adminUserMapper.insert(adminUser);
    }
}
