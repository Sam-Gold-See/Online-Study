package com.study.handler;

import com.study.constant.MessageConstant;
import com.study.exception.BusinessException;
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
    public Result<String> exceptionHandler(BusinessException e) {
        log.error("异常信息:{}", e.getMessage());
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
        log.error("SQL 约束异常:{}", message);

        // 处理唯一约束冲突问题
        // 'Duplicate entry 'admin' for key 'admin_user.username'
        if (message.contains("Duplicate entry")) {
            // 使用正则表达式提取冲突值，如 `admin`
            Pattern pattern = Pattern.compile("Duplicate entry '(.*?)' for key '(.*?)'");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String conflictValue = matcher.group(1); // 获取冲突字段的值
                String conflictKey = matcher.group(2); // 获取冲突的唯一索引名称
                if (conflictKey.contains("admin_user.username"))
                    return Result.error("账号 '" + conflictValue + "' 已存在！");
                else if (conflictKey.contains("admin_user.phone"))
                    return Result.error("手机号 '" + conflictValue + "' 已被注册！");
                else if (conflictKey.contains("client_user.email"))
                    return Result.error("邮箱 '" + conflictValue + "' 已被注册！");
                else if (conflictKey.contains("favourite.unique_favourite"))
                    return Result.error("已收藏，无法重复收藏");
                else if (conflictKey.contains("like.unique_like_post"))
                    return Result.error("已点赞，无法重复点赞");
            }
        }
        // 其他未知 SQL 约束异常，返回通用错误信息
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}
