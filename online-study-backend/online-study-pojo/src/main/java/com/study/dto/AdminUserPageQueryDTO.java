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
public class AdminUserPageQueryDTO implements Serializable {

    // 用户名
    private String name;

    // 用户手机
    private String phone;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 登录权限（1=正常，0=禁用）
    private Integer status;

    // 是否用权限修改其他B端用户（1=有权限，0=无）
    private Integer level;

    // 页码数
    private Integer page;

    // 每页显示记录数
    private Integer pageSize;
}
