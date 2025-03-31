package com.study.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdUtil {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final Integer MAX_COUNT = 99;

    /**
     * 生成递增 ID
     *
     * @return 生成的唯一 ID
     */
    public static synchronized long generateId(String roleSignal) {
        long timestamp = System.currentTimeMillis(); // 当前时间戳（毫秒）
        int count = counter.getAndIncrement(); // 递增计数器

        // 避免溢出，超过最大值重置
        if (count >= MAX_COUNT) {
            counter.set(0);
            count = 0;
        }

        // 组合时间戳 + 自增数，确保递增
        return Long.parseLong(roleSignal + timestamp + String.format("%02d", count));
    }

    /**
     * 判断是否为管理员账号
     *
     * @param id 账号id
     */
    public static boolean isAdmin(Long id) {
        if (id == null)
            return false;
        return String.valueOf(id).startsWith("1");
    }

    /**
     * 判断是否为用户账号
     *
     * @param id 账号id
     */
    public static boolean isClient(Long id) {
        if (id == null)
            return false;
        return String.valueOf(id).startsWith("2");
    }
}
