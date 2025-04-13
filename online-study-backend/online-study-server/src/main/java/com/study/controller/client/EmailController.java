package com.study.controller.client;

import com.study.dto.ClientUserDTO;
import com.study.result.Result;
import com.study.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/client/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * 请求验证码
     *
     * @param email 目标邮箱
     */
    @GetMapping("/sendCode")
    public Result<String> sendCode(String email) {
        log.info("请求验证码:{}", email);
        emailService.sendCode(email);
        return Result.success();
    }

    /**
     * 验证验证码
     *
     * @param clientUserDTO C端用户DTO
     */
    @PostMapping("/checkCode")
    public Result<String> checkCode(@RequestBody ClientUserDTO clientUserDTO) {
        log.info("验证验证码(邮箱{}):{}", clientUserDTO.getEmail(), clientUserDTO.getVerificationCode());
        emailService.checkCode(clientUserDTO);
        return Result.success();
    }
}
