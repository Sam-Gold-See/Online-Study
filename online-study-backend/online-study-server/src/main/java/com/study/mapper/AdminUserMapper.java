package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.AdminUser;
import com.study.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {

    /**
     * 根据id查询管理员是否有权限
     *
     * @param id 管理员Id
     */
    @Select("SELECT status FROM admin_user WHERE id = #{id}")
    Boolean checkById(Long id);

    /**
     * 插入数据
     *
     * @param adminUser 管理员用户实体类
     */
    @AutoFill(OperationType.INSERT)
    @Insert("INSERT INTO admin_user " +
            "(id, name, username, password, phone, gender, create_time, update_time, create_user, update_user) " +
            "VALUES(#{id}, #{name}, #{username}, #{password}, #{phone}, #{gender}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(AdminUser adminUser);

    /**
     * 根据用户账号查询数据
     *
     * @param username 登录账号
     * @return AdminUser 管理员用户对象类
     */
    @Select("SELECT * FROM admin_user WHERE username = #{username}")
    AdminUser getByUsername(String username);
}
