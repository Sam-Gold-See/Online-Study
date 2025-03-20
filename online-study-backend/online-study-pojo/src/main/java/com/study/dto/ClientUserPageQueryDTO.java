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
public class ClientUserPageQueryDTO implements Serializable {

    // 用户名
    private String name;

    // 用户邮箱号
    private String email;

    // 用户性别（M：男，女：F）
    private Character gender;

    // 使用权限（1=正常，0=禁用）
    private Integer status;

    // 页码数
    private Integer page;

    // 每页显示记录数
    private Integer pageSize;
}
