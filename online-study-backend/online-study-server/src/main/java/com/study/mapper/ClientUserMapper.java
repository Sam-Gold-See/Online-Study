package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.ClientUser;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientUserMapper {

    /**
     * 插入数据
     *
     * @param clientUser 客户端用户实体类
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO client_user " +
            "(id, name, phone, password, gender, avatar, create_time, update_time) " +
            "VALUES(#{id}, #{name}, #{phone}, #{password}, #{gender}, #{avatar}, #{createTime}, #{updateTime})")
    void insert(ClientUser clientUser);
}
