package com.study.service;

import com.study.dto.AdminUserDTO;

public interface AdminUserService {

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO对象
     */
    void add(AdminUserDTO adminUserDTO);
}
