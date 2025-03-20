package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.ClientUserPageQueryDTO;
import com.study.entity.ClientUser;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import com.study.vo.ClientUserVO;
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
     *
     * @param email 用户邮箱
     */
    @Select("SELECT * FROM client_user WHERE email = #{email}")
    ClientUser getByEmail(String email);

    /**
     * 动态更新C端用户信息
     *
     * @param clientUser C端用户对象实体类
     */
    @AutoFill(operation = OperationType.UPDATE, terminal = TerminalType.CLIENT)
    void update(ClientUser clientUser);

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     */
    @Select("SELECT * FROM client_user WHERE id = #{id}")
    ClientUser getById(Long id);

    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO
     */
    Page<ClientUserVO> query(ClientUserPageQueryDTO clientUserPageQueryDTO);
}
