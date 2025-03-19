package com.study.controller.admin;

import com.study.dto.AdminUserDTO;
import com.study.result.Result;
import com.study.service.AdminUserService;
import com.study.vo.AdminUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
@Slf4j
public class UserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 新增B端用户
     *
     * @param adminUserDTO B端用户DTO
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody AdminUserDTO adminUserDTO) {
        adminUserService.add(adminUserDTO);
        log.info("新增B端用户：{}", adminUserDTO);
        return Result.success();
    }

    /**
     * B端用户登录
     *
     * @param adminUserDTO B端用户DTO
     */
    @PostMapping("/login")
    public Result<AdminUserLoginVO> login(@RequestBody AdminUserDTO adminUserDTO) {
        AdminUserLoginVO adminUserLoginVO = adminUserService.login(adminUserDTO);
        log.info("B端用户登录：{}", adminUserDTO);
        return Result.success(adminUserLoginVO);
    }
}
