package com.study.service;

import com.study.dto.ClientUserRegistDTO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserRegistDTO C端用户注册DTO
     */
    void add(ClientUserRegistDTO clientUserRegistDTO);
}
