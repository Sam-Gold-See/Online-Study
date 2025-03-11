package com.study.service;

import com.study.dto.AdminUserDTO;
import com.study.dto.AdminUserLoginDTO;
import com.study.vo.AdminUserLoginVO;

public interface AdminUserService {

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO对象
     */
    void add(AdminUserDTO adminUserDTO);

    /**
     * 用户登录
     *
     * @param adminUserLoginDTO B端用户登录DTO对象
     * @return AdminUserLoginVO B端用户登录VO对象
     */
    AdminUserLoginVO login(AdminUserLoginDTO adminUserLoginDTO);
}
