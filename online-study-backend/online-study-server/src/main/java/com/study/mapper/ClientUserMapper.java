package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.clientuser.ClientUserPageQueryDTO;
import com.study.entity.ClientUser;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 动态更新
     *
     * @param clientUser 客户端对象实体类
     */
    @AutoFill(operation = OperationType.UPDATE, terminal = TerminalType.CLIENT)
    void update(ClientUser clientUser);

    /**
     * 根据id查询用户数据
     *
     * @param userId 客户端用户Id
     * @return ClientUser客户端用户实体类
     */
    @Select("SELECT * FROM client_user WHERE id = #{userId}")
    ClientUser getById(Long userId);

    /**
     * 更新用户Email
     *
     * @param clientUser 客户端用户实体类
     */
    @Update("UPDATE client_user SET email = #{email} WHERE id = #{id}")
    @AutoFill(operation = OperationType.UPDATE, terminal = TerminalType.CLIENT)
    void updateEmail(ClientUser clientUser);


    /**
     * C端用户分页查询
     *
     * @param clientUserPageQueryDTO C端用户分页查询DTO对象
     * @return PageResult<AdminUser> ClientUser类的分页查询对象
     */
    Page<ClientUser> getListPage(ClientUserPageQueryDTO clientUserPageQueryDTO);
}
