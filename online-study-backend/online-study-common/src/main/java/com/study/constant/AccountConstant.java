package com.study.constant;

public class AccountConstant {

    // 账号状态正常可登录
    public static final Integer ENABLED = 1;

    // 账号状态异常不可登录
    public static final Integer DISABLED = 0;

    // 账号有权限修改信息
    public static final Integer PERMISSION = 1;

    // 账号无权限修改信息
    public static final Integer PERMISSION_DENIED = 0;

    // 账号操作的验证码起始位置
    public static final Integer VERIFICATION_CODE_START = 0;

    // 账号操作的验证码长度
    public static final Integer VERIFICATION_CODE_LENGTH = 6;

    // 验证码有效时长
    public static final Integer VERIFICATION_CODE_TTL = 1;
}
