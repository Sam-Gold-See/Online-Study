package com.study.exception;

public class PasswordErrorException extends RuntimeException {
    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }
}
