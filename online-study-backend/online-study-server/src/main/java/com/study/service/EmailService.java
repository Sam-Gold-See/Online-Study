package com.study.service;

import com.study.dto.ClientUserDTO;

public interface EmailService {

    /**
     * 请求验证码
     *
     * @param email 目标邮箱
     */
    void sendCode(String email);

    /**
     * 验证验证码
     *
     * @param clientUserDTO C端用户DTO
     */
    void checkCode(ClientUserDTO clientUserDTO);
}
