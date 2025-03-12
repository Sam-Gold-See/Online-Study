package com.study.conrtoller.user;

import com.study.dto.ClientUserDTO;
import com.study.dto.ClientUserLoginDTO;
import com.study.result.Result;
import com.study.service.ClientUserService;
import com.study.vo.ClientUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
@Slf4j
public class ClientUserController {

    @Autowired
    ClientUserService clientUserService;

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/regist")
    public Result<String> regist(@RequestBody ClientUserDTO clientUserDTO) {
        clientUserService.add(clientUserDTO);
        return Result.success();
    }

    /**
     * 用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO对象
     * @return Result<ClientUserLoginVO> C端用户登录VO对象
     */
    @PostMapping("/login")
    public Result<ClientUserLoginVO> login(@RequestBody ClientUserLoginDTO clientUserLoginDTO) {
        ClientUserLoginVO clientUserLoginVO = clientUserService.login(clientUserLoginDTO);
        return Result.success(clientUserLoginVO);
    }
}
