package com.study.service;

import com.study.dto.clientuser.*;
import com.study.entity.ClientUser;
import com.study.result.PageResult;
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

    /**
     * 修改密码
     *
     * @param clientUserEditPasswordDTO C端用户修改密码DTO
     */
    void editPassword(ClientUserEditPasswordDTO clientUserEditPasswordDTO);

    /**
     * 修改邮箱
     *
     * @param clientUserEditEmailDTO C端用户修改邮箱DTO
     */
    void editEmail(ClientUserEditEmailDTO clientUserEditEmailDTO);

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO对象
     * @return PageResult<AdminUser> ClientUser类的分页查询对象
     */
    PageResult<ClientUser> getClientListPage(ClientUserPageQueryDTO clientUserPageQueryDTO);
}
