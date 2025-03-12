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
public class ClientUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 时间戳唯一id
    private Long id;

    // 用户名
    private String name;

    // 用户邮箱号
    private String email;

    // 用户登录密码
    private String password;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 使用权限（1=正常，0=禁用）
    private Integer status;

    // 头像资源链接
    private String avatar;

    // 创建时间
    private LocalDateTime createTime;

    // 个人信息更新时间
    private LocalDateTime updateTime;
}
