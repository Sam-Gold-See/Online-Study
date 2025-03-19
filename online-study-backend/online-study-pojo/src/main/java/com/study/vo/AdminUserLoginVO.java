package com.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserLoginVO implements Serializable {

    // 时间戳唯一id
    private Long id;

    // 用户名
    private String name;

    // 用户登录账号
    private String username;

    // 用户手机
    private String phone;

    // 用户性别（M：男，女：F）
    private Character gender;
}
