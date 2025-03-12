package com.study.service;

import com.study.dto.ClientUserLoginDTO;
import com.study.dto.ClientUserRegistDTO;
import com.study.vo.ClientUserLoginVO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO对象
     */
    void add(ClientUserRegistDTO clientUserRegistDTO);

    /**
     * 用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO对象
     * @return ClientUserLoginVO C端用户登录VO对象
     */
    ClientUserLoginVO login(ClientUserLoginDTO clientUserLoginDTO);

    /**
     * 发送验证码
     *
     * @param toEmail 目标邮箱
     */
    void sendMsg(String toEmail);
}
