package com.study.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserDTO implements Serializable {

    // 用户id
    private Long id;

    // 用户名
    private String name;

    // 用户登录账号
    private String username;

    // 用户登录密码
    private String password;

    // 用户手机
    private String phone;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 登录权限（1=正常，0=禁用）
    private Integer status;

    // 是否用权限修改其他B端用户（1=有权限，0=无）
    private Integer level;
}
