package com.study.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientUserLoginVO implements Serializable {

    // 时间戳唯一id
    private Long id;

    // 用户名
    private String name;

    // 用户登录账号
    private String username;

    // jwt令牌
    private String token;
}
