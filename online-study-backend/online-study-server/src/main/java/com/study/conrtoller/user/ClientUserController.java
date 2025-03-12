package com.study.conrtoller.user;

import com.study.dto.ClientUserEditPasswordDTO;
import com.study.dto.ClientUserLoginDTO;
import com.study.dto.ClientUserRegistDTO;
import com.study.result.Result;
import com.study.service.ClientUserService;
import com.study.vo.ClientUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/user")
@Slf4j
public class ClientUserController {

    @Autowired
    ClientUserService clientUserService;

    /**
     * 请求验证码
     *
     * @param toEmail 邮箱账号
     * @return Result类响应对象
     */
    @GetMapping("/sendMsg")
    public Result<String> sendMsg(String toEmail) {
        clientUserService.sendMsg(toEmail);
        return Result.success();
    }

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO对象
     * @return Result类响应对象
     */
    @PostMapping("/regist")
    public Result<String> regist(@RequestBody ClientUserRegistDTO clientUserRegistDTO) {
        clientUserService.add(clientUserRegistDTO);
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

    /**
     * 修改密码
     *
     * @param clientUserEditPasswordDTO C端用户修改密码DTO
     * @return Result类响应对象
     */
    @PostMapping("/editPassword")
    public Result<String> editPassword(@RequestBody ClientUserEditPasswordDTO clientUserEditPasswordDTO) {
        clientUserService.editPassword(clientUserEditPasswordDTO);
        return Result.success();
    }
}
