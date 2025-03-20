package com.study.service;

import com.study.dto.ClientUserDTO;
import com.study.vo.ClientUserLoginVO;
import com.study.vo.ClientUserVO;

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

    /**
     * C端用户退出
     *
     * @param authentication jwt令牌
     */
    void logout(String authentication);

    /**
     * 设置C端用户登录状态
     *
     * @param clientUserDTO 用户管理DTO对象
     */
    void editStatus(ClientUserDTO clientUserDTO);

    /**
     * 查询C端用户信息
     *
     * @param id C端用户id
     */
    ClientUserVO getInfo(Long id);
}
