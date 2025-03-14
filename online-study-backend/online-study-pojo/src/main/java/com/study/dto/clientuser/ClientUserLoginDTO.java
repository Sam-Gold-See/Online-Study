package com.study.dto.clientuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientUserLoginDTO implements Serializable {

    // 用户登录账号、邮箱号
    private String email;

    // 用户登录密码
    private String password;
}
