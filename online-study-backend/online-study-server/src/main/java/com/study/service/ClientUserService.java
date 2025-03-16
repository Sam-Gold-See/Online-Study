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

    /**
     * 修改个人信息
     *
     * @param clientUserUpdateDTO 用户更新个人信息DTO
     */
    void updateInfo(ClientUserUpdateDTO clientUserUpdateDTO);

    /**
     * 查询个人信息
     *
     * @return ClientUser实体类对象
     */
    ClientUser getInfo();

    /**
     * 修改头像
     *
     * @param avatar 头像资源链接
     */
    void editAvatar(String avatar);

    /**
     * 设置C端用户账号登录状态
     *
     * @param id     C端用户id
     * @param status C端用户目标状态
     */
    void editStatus(Long id, Integer status);
}
