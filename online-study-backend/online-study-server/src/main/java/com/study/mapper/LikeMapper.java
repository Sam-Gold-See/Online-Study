package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Like;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LikeMapper {

    /**
     * 新增点赞
     *
     * @param like 点赞实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO `like` (user_id, post_id, comment_id, create_time, update_time) " +
            "VALUES (#{userId}, #{postId}, #{commentId}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Like like);

    /**
     * 根据点赞id查询点赞
     *
     * @param id 点赞id
     */
    @Select("SELECT * FROM `like` WHERE id = #{id}")
    Like getById(Long id);

    /**
     * 根据点赞id删除点赞
     *
     * @param like 点赞实体类对象
     */
    void delete(Like like);

    /**
     * 查询点赞情况
     *
     * @param like 点赞实体类对象
     */
    Integer checkById(Like like);
}
