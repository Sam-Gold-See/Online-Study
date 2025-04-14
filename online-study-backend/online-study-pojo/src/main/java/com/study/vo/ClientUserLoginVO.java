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
public class ClientUserLoginVO implements Serializable {

    // 时间戳唯一id
    private Long id;

    // 用户名
    private String name;

    // 用户邮箱号
    private String email;

    // 用户头像资源链接
    private String avatar;

    // 用户性别（M：男，女：F）
    private Character gender;

    // C端Jwt令牌
    private String authentication;
}
