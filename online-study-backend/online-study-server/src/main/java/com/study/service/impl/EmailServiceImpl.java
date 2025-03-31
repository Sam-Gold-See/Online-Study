package com.study.service.impl;

import com.study.constant.AccountConstant;
import com.study.constant.MessageConstant;
import com.study.exception.EmailException;
import com.study.service.EmailService;
import com.study.utils.EmailUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 请求验证码
     *
     * @param email 目标邮箱
     */
    @Override
    public void sendCode(String email) {
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        if (!(verificationCodeRedis == null || verificationCodeRedis.isEmpty()))
            throw new EmailException(MessageConstant.EMAIL_REPEAT);

        String verificationCode = RandomStringUtils.secure().next(6, AccountConstant.VERIFICATION_CODE_CHARS);
        EmailUtils.sendVerificationCode(email, verificationCode);

        stringRedisTemplate.opsForValue().set(AccountConstant.REDIS_KEY + email, verificationCode, AccountConstant.VERIFICATION_CODE_TTL, TimeUnit.MINUTES);
    }
}
