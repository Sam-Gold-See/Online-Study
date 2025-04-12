package com.study.interceptor;

import com.study.constant.JwtConstant;
import com.study.context.BaseContext;
import com.study.properties.JwtProperties;
import com.study.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * C端jwt令牌校验拦截器
 */

@Component
@Slf4j
public class JwtTokenClientInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties; // 注入配置类，获取 JWT 配置（如令牌名称和秘钥）

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 校验 JWT 令牌
     *
     * @param request  当前请求
     * @param response 当前响应
     * @param handler  当前处理的 handler（通常是 Controller 方法）
     * @return 返回 true 表示请求通过，false 表示请求被拦截
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1. 从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getClientTokenName());

        //2. 校验令牌
        try {
            log.info("jwt校验:{}", token);

            Claims claims = JwtUtil.parseJWT(jwtProperties.getClientSecretKey(), token);
            String email = claims.get(JwtConstant.CLIENT_EMAIL).toString();

            if (!Objects.equals(stringRedisTemplate.opsForValue().get(JwtConstant.AUTHENTICATION_LIST + email), token)) {
                log.warn("jwt令牌已失效:{}", token);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            // 解析用户id
            Long clientUserId = Long.valueOf(claims.get(JwtConstant.CLIENT_ID).toString());
            log.info("当前C端用户id:{}", clientUserId);

            // 设置当前用户id
            BaseContext.setCurrentId(clientUserId);
            return true;
        } catch (Exception ex) {
            //4. 不通过，响应401状态码（未经授权）
            log.warn("jwt令牌异常:{}", token);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 清除当前线程中的用户 ID
        BaseContext.removeCurrentId();
    }
}
