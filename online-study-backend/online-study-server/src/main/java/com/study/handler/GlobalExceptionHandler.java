package com.study.handler;

import com.study.exception.BusinessException;
import com.study.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param e BaseException 业务异常类
     * @return Result响应对象类
     */
    @ExceptionHandler
    public Result<String> exceptionHandler(BusinessException e) {
        log.error("异常信息:{}", e.getMessage());
        return Result.error(e.getMessage());
    }
}
