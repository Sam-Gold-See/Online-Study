package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.FavouritePageQueryDTO;
import com.study.entity.Favourite;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 删除收藏
     *
     * @param favourite 收藏实体类对象
     */
    @Delete("DELETE FROM favourite WHERE user_id = #{userId} AND post_id = #{postId}")
    void delete(Favourite favourite);


    /**
     * 分页查询
     *
     * @param favouritePageQueryDTO 收藏分页查询DTO对象
     */
    Page<Favourite> query(FavouritePageQueryDTO favouritePageQueryDTO);
}