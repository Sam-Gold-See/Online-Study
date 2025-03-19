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
}
