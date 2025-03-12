package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientUserEditEmailDTO {

    // 现在的邮箱
    private String oldEmail;

    // 密码
    private String password;

    // 改后的邮箱
    private String newEmail;

    // 新邮箱的验证码
    private String verificationCode;
}
