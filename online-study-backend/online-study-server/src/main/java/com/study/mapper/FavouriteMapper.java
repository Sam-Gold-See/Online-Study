package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Favourite;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavouriteMapper {

    /**
     * 新增收藏
     *
     * @param favourite 收藏实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO favourite (user_id, post_id, create_time, update_time) " +
            "VALUES (#{userId}, #{postId}, #{createTime}, #{updateTime})")
    void insert(Favourite favourite);
}
