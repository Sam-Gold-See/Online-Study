package com.study.exception;

public class PostNotFoundException extends BaseException {
    public PostNotFoundException() {
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}
