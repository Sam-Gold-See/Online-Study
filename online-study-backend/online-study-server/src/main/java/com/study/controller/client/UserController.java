package com.study.controller.client;

import com.study.dto.ClientUserDTO;
import com.study.result.Result;
import com.study.service.ClientUserService;
import com.study.vo.ClientUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ClientUserController")
@Slf4j
@RequestMapping("/client/user")
public class UserController {

    @Autowired
    private ClientUserService clientUserService;

    /**
     * C端用户注册
     *
     * @param clientUserDTO C端用户DTO
     */
    @PostMapping("/regist")
    public Result<String> regist(@RequestBody ClientUserDTO clientUserDTO) {
        clientUserService.add(clientUserDTO);
        return Result.success();
    }

    /**
     * C端用户登录
     *
     * @param clientUserDTO C端用户DTO
     */
    @PostMapping("/login")
    public Result<ClientUserLoginVO> login(@RequestBody ClientUserDTO clientUserDTO) {
        ClientUserLoginVO clientUserLoginVO = clientUserService.login(clientUserDTO);
        return Result.success(clientUserLoginVO);
    }
}
