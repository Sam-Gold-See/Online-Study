package com.study.controller.client;

import com.study.context.BaseContext;
import com.study.dto.ClientUserDTO;
import com.study.result.Result;
import com.study.service.ClientUserService;
import com.study.vo.ClientUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ClientUserController")
@RequestMapping("/client/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
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
        log.info("C端用户注册:{}", clientUserDTO);
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
        log.info("C端用户登录:{}", clientUserDTO);
        ClientUserLoginVO clientUserLoginVO = clientUserService.login(clientUserDTO);
        return Result.success(clientUserLoginVO);
    }

    /**
     * C端用户重置密码
     *
     * @param clientUserDTO C端用户DTO
     */
    @PutMapping("/editPassword")
    public Result<String> editPassword(@RequestBody ClientUserDTO clientUserDTO) {
        log.info("C端用户重置密码:{}", clientUserDTO);
        clientUserService.editPassword(clientUserDTO);
        return Result.success();
    }

    /**
     * C端用户重置邮箱
     *
     * @param clientUserDTO C端用户DTO
     */
    @PutMapping("/editEmail")
    public Result<String> editEmail(@RequestBody ClientUserDTO clientUserDTO) {
        log.info("C端用户重置邮箱:{}", clientUserDTO);
        clientUserService.editEmail(clientUserDTO);
        return Result.success();
    }

    /**
     * C端用户修改个人信息
     *
     * @param clientUserDTO C端用户DTO
     */
    @PutMapping("/editInfo")
    public Result<String> editInfo(@RequestBody ClientUserDTO clientUserDTO) {
        log.info("C端用户修改个人信息:{}", clientUserDTO);
        clientUserService.editInfo(clientUserDTO);
        return Result.success();
    }

    /**
     * C端用户退出
     *
     * @param authentication jwt令牌
     */
    @GetMapping("/logout")
    public Result<String> logout(@RequestHeader String authentication) {
        log.info("C端用户退出，用户id:{}", BaseContext.getCurrentId());
        clientUserService.logout(authentication);
        return Result.success();
    }
}
