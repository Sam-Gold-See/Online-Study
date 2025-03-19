package com.study.service;

import com.study.dto.ClientUserLoginDTO;
import com.study.dto.ClientUserRegistDTO;
import com.study.vo.ClientUserLoginVO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO
     */
    void add(ClientUserRegistDTO clientUserRegistDTO);

    /**
     * C端用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO
     */
    ClientUserLoginVO login(ClientUserLoginDTO clientUserLoginDTO);
}
