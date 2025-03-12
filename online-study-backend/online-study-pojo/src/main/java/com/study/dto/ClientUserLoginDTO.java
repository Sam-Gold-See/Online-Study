package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientUserLoginDTO {

    // 用户登录账号、邮箱号
    private String email;

    // 用户登录密码
    private String password;
}
