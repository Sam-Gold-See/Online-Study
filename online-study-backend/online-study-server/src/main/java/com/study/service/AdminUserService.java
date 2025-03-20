package com.study.service;

import com.study.dto.AdminUserDTO;
import com.study.dto.AdminUserPageQueryDTO;
import com.study.entity.AdminUser;
import com.study.result.PageResult;
import com.study.vo.AdminUserLoginVO;
import com.study.vo.AdminUserVO;

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

    /**
     * 分页查询B端用户
     *
     * @param adminUserPageQueryDTO B端用户分页查询DTO对象
     */
    PageResult<AdminUserVO> query(AdminUserPageQueryDTO adminUserPageQueryDTO);
}
