package com.study.service;

import com.study.dto.AdminUserDTO;
import com.study.vo.AdminUserLoginVO;

public interface AdminUserService {

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO
     */
    void add(AdminUserDTO adminUserDTO);

    /**
     * B端用户登录
     *
     * @param adminUserDTO B端用户DTO
     */
    AdminUserLoginVO login(AdminUserDTO adminUserDTO);
}
