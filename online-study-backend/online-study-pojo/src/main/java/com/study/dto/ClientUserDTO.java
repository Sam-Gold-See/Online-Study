package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUserDTO implements Serializable {

    // 用户名
    private String name;

    // 用户登录账号、手机号
    private String phone;

    // 用户登录密码
    private String password;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 用户头像资源链接
    private String avatar;
}
