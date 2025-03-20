package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Post;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    /**
     * 新增帖子
     *
     * @param post 帖子实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO post (user_id, title, content, create_time, update_time, category_id) " +
            "VALUES (#{userId}, #{title}, #{content}, #{createTime}, #{updateTime}, #{categoryId})")
    void insert(Post post);
}
