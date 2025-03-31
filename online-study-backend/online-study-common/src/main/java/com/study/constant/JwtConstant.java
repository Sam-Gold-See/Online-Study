package com.study.constant;

/**
 * jwt常量类
 */
public class JwtConstant {

    // 管理端jwt（token）载荷常量的键值
    public static final String ADMIN_ID = "adminId";

    // 管理端jwt （token）载荷常量的账号键值
    public static final String ADMIN_USERNAME = "adminUsername";

    // Redis中管理端jwt键值
    public static final String TOKEN_LIST = "jwt:tokenList:";

    // 客户端jwt （authentication）载荷常量的id键值
    public static final String CLIENT_ID = "clientId";

    // 客户端jwt （authentication）载荷常量的账号键值
    public static final String CLIENT_EMAIL = "clientEmail";

    // Redis中客户端jwt键值
    public static final String AUTHENTICATION_LIST = "jwt:authenticationList:";
}
