package com.study.controller.admin;

import com.study.dto.ClientUserDTO;
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
}
