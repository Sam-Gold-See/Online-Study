package com.study.service;

import com.study.dto.ClientUserDTO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO对象
     */
    void add(ClientUserDTO clientUserDTO);
}
