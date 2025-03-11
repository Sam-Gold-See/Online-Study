package com.study.exception;

/**
 * 管理员账号权限异常
 */
public class AdminUserLevelException extends BaseException {

    public AdminUserLevelException() {
    }

    public AdminUserLevelException(String message) {
        super(message);
    }
}
