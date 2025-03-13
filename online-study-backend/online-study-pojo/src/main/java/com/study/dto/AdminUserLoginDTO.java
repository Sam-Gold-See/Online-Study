package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserLoginDTO implements Serializable {

    // 用户登录账号
    private String username;

    // 用户登录密码
    private String password;
}
