package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Like;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

    /**
     * 新增点赞
     *
     * @param like 点赞实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO `like` (user_id, post_id, comment_id, create_time) " +
            "VALUES (#{userId}, #{postId}, #{commentId}, #{createTime})")
    void insert(Like like);
}
