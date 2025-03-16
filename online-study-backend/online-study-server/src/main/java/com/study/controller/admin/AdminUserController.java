package com.study.controller.admin;

import com.study.dto.adminuser.AdminUserDTO;
import com.study.dto.adminuser.AdminUserLoginDTO;
import com.study.dto.adminuser.AdminUserPageQueryDTO;
import com.study.entity.AdminUser;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.AdminUserService;
import com.study.vo.AdminUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("bAdminUserController")
@RequestMapping("/admin/user")
@Slf4j
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody AdminUserDTO adminUserDTO) {
        adminUserService.add(adminUserDTO);
        return Result.success();
    }

    /**
     * 用户登录
     *
     * @param adminUserLoginDTO B端用户登录DTO对象
     * @return Result<AdminUserLoginVO> B端用户登录VO对象
     */
    @PostMapping("/login")
    public Result<AdminUserLoginVO> login(@RequestBody AdminUserLoginDTO adminUserLoginDTO) {
        AdminUserLoginVO adminUserLoginVO = adminUserService.login(adminUserLoginDTO);
        return Result.success(adminUserLoginVO);
    }

    /**
     * 启用、禁用B端用户登录权限
     *
     * @param id     用户id
     * @param status 目标状态
     * @return Result类响应对象
     */
    @GetMapping("/editStatus")
    public Result<String> editStatus(Long id, Integer status) {
        adminUserService.editStatus(id, status);
        return Result.success();
    }

    /**
     * 启用、禁用B端用户修改权限
     *
     * @param id    用户id
     * @param level 目标权限
     * @return Result类响应对象
     */
    @GetMapping("/editLevel")
    public Result<String> editLevel(Long id, Integer level) {
        adminUserService.editLevel(id, level);
        return Result.success();
    }

    /**
     * B端用户分页查询
     *
     * @param adminUserPageQueryDTO B端用户分页查询DTO对象
     * @return Result类响应对象
     */
    @GetMapping("/page")
    public Result<PageResult<AdminUser>> getAdminListPage(AdminUserPageQueryDTO adminUserPageQueryDTO) {
        PageResult<AdminUser> pageResult = adminUserService.getAdminListPage(adminUserPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * B端用户数据查询
     *
     * @param id 用户id
     * @return Result类响应对象
     */
    @GetMapping
    public Result<AdminUser> getAdmin(Long id) {
        AdminUser adminUser = adminUserService.getById(id);
        return Result.success(adminUser);
    }

    /**
     * B端用户数据更新
     *
     * @param adminUser B端用户
     * @return Result类响应对象
     */
    @PostMapping("/update")
    public Result<String> updateAdmin(@RequestBody AdminUser adminUser) {
        adminUserService.updateAdmin(adminUser);
        return Result.success();
    }
}