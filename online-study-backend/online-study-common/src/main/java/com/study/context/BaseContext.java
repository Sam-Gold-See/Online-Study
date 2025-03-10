package com.study.context;

/**
 * 线程上下文管理
 */

public class BaseContext {

    /**
     * ThreadLocal 变量存储当前线程的用户ID
     */
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前线程的用户ID
     *
     * @return 当前用户ID
     */
    public static Long getCurrentId() {
        return threadLocal.get();
    }

    /**
     * 设置当前线程的用户ID
     *
     * @param id 当前用户ID
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 移除当前线程的用户ID，防止内存泄露
     */
    public static void removeCurrentId() {
        threadLocal.remove();
    }
}
