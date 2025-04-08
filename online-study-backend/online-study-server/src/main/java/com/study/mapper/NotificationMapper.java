package com.study.mapper;

import com.study.annotation.AutoFill;
import com.study.entity.Notification;
import com.study.enumeration.OperationType;
import com.study.enumeration.TerminalType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationMapper {

    /**
     * 新增通知
     *
     * @param notification 通知实体类对象
     */
    @AutoFill(operation = OperationType.INSERT, terminal = TerminalType.CLIENT)
    @Insert("INSERT INTO notification (user_id, type, source_id, comment_id, create_time, update_time) VALUES (#{userId}, #{type}, #{sourceId}, #{commentId}, #{createTime}, #{updateTime})")
    void insert(Notification notification);
}
