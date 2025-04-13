package com.study.controller.admin;

import com.study.context.BaseContext;
import com.study.dto.AdminUserDTO;
import com.study.dto.AdminUserPageQueryDTO;
import com.study.entity.AdminUser;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.AdminUserService;
import com.study.vo.AdminUserLoginVO;
import com.study.vo.AdminUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        log.info("新增B端用户:{}", adminUserDTO);
        adminUserService.add(adminUserDTO);
        return Result.success();
    }

    /**
     * B端用户登录
     *
     * @param adminUserDTO B端用户DTO
     */
    @PostMapping("/login")
    public Result<AdminUserLoginVO> login(@RequestBody AdminUserDTO adminUserDTO) {
        log.info("B端用户登录:{}", adminUserDTO);
        AdminUserLoginVO adminUserLoginVO = adminUserService.login(adminUserDTO);
        return Result.success(adminUserLoginVO);
    }

    /**
     * 设置B端用户登录权限
     *
     * @param adminUserDTO B端用户DTO
     */
    @PutMapping("/editStatus")
    public Result<String> editStatus(@RequestBody AdminUserDTO adminUserDTO) {
        log.info("设置B端用户(id:{})登录权限为:{}", adminUserDTO.getId(), adminUserDTO.getStatus());
        adminUserService.editStatus(adminUserDTO);
        return Result.success();
    }

    /**
     * 设置B端用户修改权限
     *
     * @param adminUserDTO B端用户DTO
     */
    @PutMapping("/editLevel")
    public Result<String> editLevel(@RequestBody AdminUserDTO adminUserDTO) {
        log.info("设置B端用户(id:{})修改权限为:{}", adminUserDTO.getId(), adminUserDTO.getLevel());
        adminUserService.editLevel(adminUserDTO);
        return Result.success();
    }

    /**
     * 设置B端用户信息
     *
     * @param adminUserDTO B端用户DTO
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody AdminUserDTO adminUserDTO) {
        log.info("设置B端用户(id:{})信息为:{}", adminUserDTO.getId(), adminUserDTO);
        adminUserService.update(adminUserDTO);
        return Result.success();
    }

    /**
     * 查询B端用户信息
     *
     * @param id B端用户id
     */
    @GetMapping("/getInfo")
    public Result<AdminUser> getInfo(Long id) {
        log.info("查询B端用户(id:{})", id);
        AdminUser adminUser = adminUserService.getInfo(id);
        return Result.success(adminUser);
    }

    /**
     * B端用户退出
     *
     * @param token jwt令牌
     */
    @GetMapping("/logout")
    public Result<String> logout(@RequestHeader String token) {
        log.info("B端用户退出，用户id:{}", BaseContext.getCurrentId());
        adminUserService.logout(token);
        return Result.success();
    }

    /**
     * B端用户分页查询
     *
     * @param adminUserPageQueryDTO B端用户分页查询DTO对象
     */
    @GetMapping("/query")
    public Result<PageResult<AdminUserVO>> query(@RequestBody AdminUserPageQueryDTO adminUserPageQueryDTO) {
        log.info("B端用户分页查询，条件为:{}", adminUserPageQueryDTO);
        PageResult<AdminUserVO> pageResult = adminUserService.query(adminUserPageQueryDTO);
        return Result.success(pageResult);
    }
}
