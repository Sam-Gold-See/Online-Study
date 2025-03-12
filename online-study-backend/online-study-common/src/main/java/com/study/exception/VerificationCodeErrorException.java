package com.study.exception;

public class VerificationCodeErrorException extends BaseException {
    public VerificationCodeErrorException() {
    }

    public VerificationCodeErrorException(String message) {
        super(message);
    }
}
