package com.study.controller.client;

import com.study.dto.ClientUserLoginDTO;
import com.study.dto.ClientUserRegistDTO;
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
     * @param clientUserRegistDTO C端用户注册DTO
     */
    @PostMapping("/regist")
    public Result<String> regist(@RequestBody ClientUserRegistDTO clientUserRegistDTO) {
        clientUserService.add(clientUserRegistDTO);
        return Result.success();
    }

    /**
     * C端用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO
     */
    @PostMapping("/login")
    public Result<ClientUserLoginVO> login(@RequestBody ClientUserLoginDTO clientUserLoginDTO) {
        ClientUserLoginVO clientUserLoginVO = clientUserService.login(clientUserLoginDTO);
        return Result.success(clientUserLoginVO);
    }
}
