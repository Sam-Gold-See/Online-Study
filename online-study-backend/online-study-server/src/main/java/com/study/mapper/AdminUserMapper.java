package com.study.mapper;

import com.study.entity.AdminUser;
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
}
