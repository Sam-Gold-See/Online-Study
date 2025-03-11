package com.study.exception;

/**
 * 管理员账号状态异常
 */
public class AdminUserStatusException extends BaseException {

    public AdminUserStatusException() {
    }

    public AdminUserStatusException(String message) {
        super(message);
    }
}
