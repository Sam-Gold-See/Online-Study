package com.study.service.impl;

import com.study.constant.IdConstant;
import com.study.constant.MessageConstant;
import com.study.context.BaseContext;
import com.study.dto.AdminUserDTO;
import com.study.entity.AdminUser;
import com.study.exception.AdminUserLevelException;
import com.study.mapper.AdminUserMapper;
import com.study.service.AdminUserService;
import com.study.utils.IdGeneratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO对象
     */
    @Override
    public void add(AdminUserDTO adminUserDTO) {
        // 校验当前管理员账号是否有权限
        Long creatorId = BaseContext.getCurrentId();
        Boolean status = adminUserMapper.checkById(creatorId);
        if (!status)
            throw new AdminUserLevelException(MessageConstant.PERMISSION_DENIED);

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDTO, adminUser);

        Long Id = IdGeneratorUtil.generateId(IdConstant.ADMIN_SIGNAL);
        adminUser.setId(Id);

        adminUserMapper.insert(adminUser);
    }
}
