package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientUserDTO implements Serializable {

    // 用户名
    private String name;

    // 用户邮箱号
    private String email;

    // 用户登录密码
    private String password;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 验证码
    private String verificationCode;

    // 旧邮箱
    private String oldEmail;
}
