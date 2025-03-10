package com.study.exception;

/**
 * 自定义业务异常基类
 */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
