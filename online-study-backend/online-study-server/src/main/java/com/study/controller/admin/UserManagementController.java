package com.study.controller.admin;

import com.study.dto.ClientUserDTO;
import com.study.dto.ClientUserPageQueryDTO;
import com.study.result.PageResult;
import com.study.result.Result;
import com.study.service.ClientUserService;
import com.study.vo.ClientUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/userManagement")
@Slf4j
public class UserManagementController {

    @Autowired
    private ClientUserService clientUserService;

    /**
     * 设置C端用户登录权限
     *
     * @param clientUserDTO 用户管理DTO对象
     */
    @PutMapping("/editStatus")
    public Result<String> editStatus(@RequestBody ClientUserDTO clientUserDTO) {
        clientUserService.editStatus(clientUserDTO);
        log.info("B端设置C端用户(id：{})的登录状态为：{}", clientUserDTO.getId(), clientUserDTO.getStatus());
        return Result.success();
    }

    /**
     * 查询C端用户信息
     *
     * @param id C端用户id
     */
    @GetMapping("/getInfo")
    public Result<ClientUserVO> getInfo(Long id) {
        ClientUserVO clientUserVO = clientUserService.getInfo(id);
        log.info("B端查询C端用户：{}", clientUserVO);
        return Result.success(clientUserVO);
    }

    /**
     * 设置C端用户信息
     *
     * @param clientUserDTO C端用户DTO对象
     */
    @PostMapping("/setInfo")
    public Result<String> setInfo(@RequestBody ClientUserDTO clientUserDTO) {
        clientUserService.setInfo(clientUserDTO);
        log.info("B端设置C端用户信息：{}", clientUserDTO);
        return Result.success();
    }

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO
     */
    @GetMapping("/query")
    public Result<PageResult<ClientUserVO>> query(@RequestBody ClientUserPageQueryDTO clientUserPageQueryDTO) {
        PageResult<ClientUserVO> pageResult = clientUserService.query(clientUserPageQueryDTO);
        log.info("C端用户分页查询，条件为：{}", clientUserPageQueryDTO);
        return Result.success(pageResult);
    }
}
