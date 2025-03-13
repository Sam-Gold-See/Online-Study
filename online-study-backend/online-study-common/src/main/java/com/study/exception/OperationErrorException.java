package com.study.exception;

public class OperationErrorException extends BaseException {
    public OperationErrorException() {
    }

    public OperationErrorException(String message) {
        super(message);
    }
}
