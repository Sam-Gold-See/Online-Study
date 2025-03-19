package com.study.constant;

/**
 * jwt常量类
 */
public class JwtConstant {

    // 管理端jwt（token）载荷常量的键值
    public static final String ADMIN_ID = "adminId";

    // 客户端jwt （authentication）载荷常量的键值
    public static final String CLIENT_ID = "clientId";

    // Redis中jwt黑名单键值
    public static final String BLACKLIST_KEY = "jwt:blacklist:";
}
