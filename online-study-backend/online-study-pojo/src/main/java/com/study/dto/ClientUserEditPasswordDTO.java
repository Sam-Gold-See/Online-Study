package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientUserEditPasswordDTO {

    // 用户邮箱、用户账号
    private String email;

    // 验证码
    private String verificationCode;

    // 新密码
    private String password;
}
