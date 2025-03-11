package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 时间戳唯一id
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

    // 使用权限（1=正常，0=禁用）
    private Integer status;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建用户ID
    private Long createUser;

    // 更新用户ID
    private Long updateUser;

    // 是否用权限管理其他管理端用户
    private Integer level;
}
