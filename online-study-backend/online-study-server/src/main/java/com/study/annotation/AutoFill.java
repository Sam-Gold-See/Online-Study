package com.study.annotation;

import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识需要进行公共字段自动填充处理的方法
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 指定数据库的操作类型：UPDATE INSERT
    OperationType operation();

    // 指定客户端的种类：ADMIN CLIENT
    TerminalType terminal();
}
