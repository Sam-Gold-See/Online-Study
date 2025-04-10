package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Notification;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import com.study.vo.NotificationVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotificationMapper {

    /**
     * 新增通知
     *
     * @param notification 通知实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO notification (from_id, to_id, type, post_id, comment_id, content, create_time, update_time) " +
            "VALUES (#{fromId}, #{toId}, #{type}, #{postId}, #{commentId}, #{content}, #{createTime}, #{updateTime})")
    void insert(Notification notification);

    /**
     * 查询通知
     *
     * @param notification 通知实体类对象
     */
    @Select("SELECT * FROM notification WHERE to_id = #{toId} AND status = #{status} ORDER BY create_time DESC")
    List<NotificationVO> getList(Notification notification);
}
