package com.study.controller.client;

import com.study.result.Result;
import com.study.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/client/email")
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
        emailService.sendCode(email);
        log.info("请求验证码：{}", email);
        return Result.success();
    }
}
