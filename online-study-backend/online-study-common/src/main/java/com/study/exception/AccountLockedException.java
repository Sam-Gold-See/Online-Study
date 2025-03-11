package com.study.exception;

public class AccountLockedException extends RuntimeException {
    public AccountLockedException() {
    }

    public AccountLockedException(String message) {
        super(message);
    }
}
