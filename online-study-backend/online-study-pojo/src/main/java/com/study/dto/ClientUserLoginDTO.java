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
public class ClientUserLoginDTO implements Serializable {

    // 用户邮箱号
    private String email;

    // 用户登录密码
    private String password;
}
