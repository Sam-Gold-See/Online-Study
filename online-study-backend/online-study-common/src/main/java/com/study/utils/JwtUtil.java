package com.study.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

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

    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     *
     * @param secretKey jwt秘钥
     * @param ttlMillis jwt过期时间(毫秒)
     * @param claims    设置的信息
     * @return jwt令牌字符串
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {
        // 生成符合 JJWT 规范的 HMAC-SHA 密钥
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        // 计算过期时间
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        // 创建 JWT 令牌
        return Jwts.builder()
                .claims(claims)     // 设置自定义载荷
                .expiration(exp)    // 设置过期时间
                .signWith(key)      // 使用密钥进行签名
                .compact();         // 生成 JWT 字符串
    }
}
