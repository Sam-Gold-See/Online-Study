package com.study.constant;

/**
 * 账号相关常量类
 */
public class AccountConstant {

    // Redis存储验证码键常量
    public static final String REDIS_KEY = "code:list:";

    // 验证码有效时长（分钟）
    public static final Integer VERIFICATION_CODE_TTL = 5;

    // 验证码字符数组
    public static final char[] VERIFICATION_CODE_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // 账号登录状态正常
    public static final Integer ENABLED = 1;

    // 账号修改权限正常
    public static final Object PERMISSION = 1;
}
