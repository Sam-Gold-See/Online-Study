package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.ClientUser;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientUserMapper {

    /**
     * 新增C端用户
     *
     * @param clientUser C端用户对象实体类
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO client_user " +
            "(id, name, email, password, gender, create_time, update_time) " +
            "VALUES(#{id}, #{name}, #{email}, #{password}, #{gender}, #{createTime}, #{updateTime})")
    void insert(ClientUser clientUser);

    /**
     * 根据Email查询用户信息
     */
    @Select("SELECT * FROM client_user WHERE email = #{email}")
    ClientUser getByEmail(String email);
}
