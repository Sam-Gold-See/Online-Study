package com.study.service;

import com.study.dto.ClientUserDTO;
import com.study.dto.ClientUserLoginDTO;
import com.study.vo.ClientUserLoginVO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO对象
     */
    void add(ClientUserDTO clientUserDTO);

    /**
     * 用户登录
     *
     * @param clientUserLoginDTO C端用户登录DTO对象
     * @return ClientUserLoginVO C端用户登录VO对象
     */
    ClientUserLoginVO login(ClientUserLoginDTO clientUserLoginDTO);
}
