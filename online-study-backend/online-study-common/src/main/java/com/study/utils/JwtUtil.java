package com.study.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;

/**
 * jwt令牌工具类
 */

public class JwtUtil {

    /**
     * 常量解析密钥
     *
     * @param secretKey JWT 密钥，至少为256位
     * @param token     需要解析的 JWT Token
     * @return 解析后的 Claims
     */
    public static Claims parseJWT(String secretKey, String token) {
        Jws<Claims> jws = Jwts.parser()// 创建JWT解析器
                .verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))// 设置JWT签名验证密钥
                .build()// 构建解析器
                .parseSignedClaims(token); // 解析JWT Token，返回Jws<Claims>对象

        return jws.getPayload(); // 从Jws<Claims>对象中提取Claims（载荷数据）
    }
}
