package com.study.controller.admin;

import com.study.dto.ClientUserDTO;
import com.study.result.Result;
import com.study.service.ClientUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/userManagement")
@Slf4j
public class UserManagementController {

    @Autowired
    private ClientUserService clientUserService;

    /**
     * 设置C端用户登录状态
     *
     * @param clientUserDTO 用户管理DTO对象
     */
    @PutMapping("/editStatus")
    public Result<String> editStatus(@RequestBody ClientUserDTO clientUserDTO) {
        clientUserService.editStatus(clientUserDTO);
        log.info("B端设置C端用户(id：{})的登录状态为：{}", clientUserDTO.getId(), clientUserDTO.getStatus());
        return Result.success();
    }
}
