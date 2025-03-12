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
     * 插入数据
     *
     * @param clientUser 客户端用户实体类
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO client_user " +
            "(id, name, email, password, gender, avatar, create_time, update_time) " +
            "VALUES(#{id}, #{name}, #{email}, #{password}, #{gender}, #{avatar}, #{createTime}, #{updateTime})")
    void insert(ClientUser clientUser);

    /**
     * 根据手机号查询用户数据
     *
     * @param email 客户端用户手机号、登录账号
     * @return ClientUser客户端用户实体类
     */
    @Select("SELECT * FROM client_user WHERE email = #{email}")
    ClientUser getByEmail(String email);
}
