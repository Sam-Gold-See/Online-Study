package com.study.handler;

import com.study.constant.MessageConstant;
import com.study.exception.BaseException;
import com.study.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Result<String> exceptionHandler(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理 SQL 违反约束异常 (`SQLIntegrityConstraintViolationException`)
     *
     * @param ex SQLIntegrityConstraintViolationException SQL 唯一约束或外键约束异常
     * @return Result<String> 返回封装的错误信息
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        // 获取异常信息
        String message = ex.getMessage();

        // 记录日志，方便调试和排查问题
        log.error("SQL 约束异常: {}", message);

        // 处理唯一约束冲突问题
        // 'Duplicate entry 'admin' for key 'admin_user.username'
        if (message.contains("Duplicate entry")) {
            // 使用正则表达式提取冲突值，如 `admin`
            Pattern pattern = Pattern.compile("Duplicate entry '(.*?)' for key");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String username = matcher.group(1); // 获取冲突字段的值
                String msg = username + MessageConstant.ALREADY_EXISTS; // 格式化提示
                return Result.error(msg); // 返回全局统一响应对象
            }
        }
        // 其他未知 SQL 约束异常，返回通用错误信息
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}
