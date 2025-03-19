package com.study.service;

import com.study.dto.ClientUserDTO;
import com.study.vo.ClientUserLoginVO;

public interface ClientUserService {

    /**
     * 新增C端用户
     *
     * @param clientUserDTO C端用户DTO
     */
    void add(ClientUserDTO clientUserDTO);

    /**
     * C端用户登录
     *
     * @param clientUserDTO C端用户DTO
     */
    ClientUserLoginVO login(ClientUserDTO clientUserDTO);

    /**
     * C端用户重置密码
     *
     * @param clientUserDTO C端用户DTO
     */
    void editPassword(ClientUserDTO clientUserDTO);

    /**
     * C端用户重置邮箱
     *
     * @param clientUserDTO C端用户DTO
     */
    void editEmail(ClientUserDTO clientUserDTO);

    /**
     * C端用户修改个人信息
     *
     * @param clientUserDTO C端用户DTO
     */
    void editInfo(ClientUserDTO clientUserDTO);
}
