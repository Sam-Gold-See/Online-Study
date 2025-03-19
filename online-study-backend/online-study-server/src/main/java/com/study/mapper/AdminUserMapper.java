package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.AdminUser;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {

    /**
     * 根据id查询B端用户修改权限
     *
     * @param userId B端用户id
     */
    @Select("SELECT level FROM admin_user WHERE id = #{id}")
    Integer checkById(Long userId);

    /**
     * 插入新B端用户
     *
     * @param adminUser B端用户实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.ADMIN)
    @Insert("INSERT INTO admin_user " +
            "(id, name, username, password, phone, gender, create_time, update_time, create_user, update_user) " +
            "VALUES (#{id}, #{name}, #{username}, #{password}, #{phone}, #{gender}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(AdminUser adminUser);
}
