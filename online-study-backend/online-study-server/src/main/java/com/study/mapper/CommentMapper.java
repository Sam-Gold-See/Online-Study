package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Comment;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    /**
     * 新增评论
     *
     * @param comment 评论实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO comment (post_id, user_id, parent_id, content, create_time, update_time) " +
            "VALUES (#{postId}, #{userId}, #{parentId}, #{content}, #{createTime}, #{updateTime})")
    void insert(Comment comment);

    /**
     * 根据id查询评论
     *
     * @param id 评论id
     */
    @Select("SELECT * FROM comment WHERE id = #{id}")
    Comment getById(Long id);

    /**
     * 动态更新评论
     *
     * @param comment 评论实体类对象
     */
    @AutoFill(operation = OperationType.UPDATE, terminal = TerminalType.CLIENT)
    void update(Comment comment);
}
