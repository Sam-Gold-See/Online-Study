package com.study.conrtoller.admin;

import com.study.dto.AdminUserDTO;
import com.study.dto.AdminUserLoginDTO;
import com.study.result.Result;
import com.study.service.AdminUserService;
import com.study.vo.AdminUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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
     * @param id 用户id
     * @return Result类响应对象
     */
    @GetMapping("/editStatus")
    public Result<String> editStatus(Long id, Integer status) {
        adminUserService.editStatus(id, status);
        return Result.success();
    }
}