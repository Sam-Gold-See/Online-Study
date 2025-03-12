package com.study.exception;

/**
 * 管理员账号状态异常
 */
public class AccountStatusException extends BaseException {

    public AccountStatusException() {
    }

    public AccountStatusException(String message) {
        super(message);
    }
}
