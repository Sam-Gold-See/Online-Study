package com.study.service;

import com.study.dto.AdminUserDTO;
import com.study.dto.AdminUserLoginDTO;
import com.study.dto.AdminUserPageQueryDTO;
import com.study.entity.AdminUser;
import com.study.result.PageResult;
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

    /**
     * 启用、禁用B端用户登录权限
     *
     * @param id     用户id
     * @param status 目标状态
     */
    void editStatus(Long id, Integer status);


    /**
     * 启用、禁用B端用户修改权限
     *
     * @param id    用户id
     * @param level 目标权限
     */
    void editLevel(Long id, Integer level);

    /**
     * B端用户分页查询
     *
     * @param adminUserPageQueryDTO B端用户分页查询DTO对象
     * @return PageResult<AdminUser> AdminUser类的分页查询对象
     */
    PageResult<AdminUser> getAdminListPage(AdminUserPageQueryDTO adminUserPageQueryDTO);

    /**
     * B端用户数据查询
     *
     * @param id 用户id
     * @return AdminUser类Admin用户实体对象
     */
    AdminUser getById(Long id);
}
