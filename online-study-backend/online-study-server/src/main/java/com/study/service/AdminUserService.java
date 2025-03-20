package com.study.service;

import com.study.dto.AdminUserDTO;
import com.study.entity.AdminUser;
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

    /**
     * B端用户退出
     *
     * @param token jwt令牌
     */
    void logout(String token);

    /**
     * 设置B端用户登录权限
     *
     * @param adminUserDTO B端用户DTO
     */
    void editStatus(AdminUserDTO adminUserDTO);

    /**
     * 设置B端用户修改权限
     *
     * @param adminUserDTO B端用户DTO
     */
    void editLevel(AdminUserDTO adminUserDTO);

    /**
     * 设置B端用户信息
     *
     * @param adminUserDTO B端用户DTO
     */
    void update(AdminUserDTO adminUserDTO);

    /**
     * 查询B端用户信息
     *
     * @param id B端用户id
     */
    AdminUser getInfo(Long id);
}
