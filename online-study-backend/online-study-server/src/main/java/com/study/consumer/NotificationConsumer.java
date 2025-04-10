package com.study.consumer;

import com.study.constant.NotificationConstant;
import com.study.constant.RabbitMQConstant;
import com.study.dto.NotificationDTO;
import com.study.entity.Notification;
import com.study.mapper.CommentMapper;
import com.study.mapper.NotificationMapper;
import com.study.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
@RabbitListener(queues = RabbitMQConstant.NOTIFICATION_QUEUE)
public class NotificationConsumer {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private NotificationMapper notificationMapper;

    /**
     * 接收到通知DTO对象存入数据库
     *
     * @param notificationDTO 通知DTO对象
     */
    @RabbitHandler
    public void receiveNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();

        BeanUtils.copyProperties(notificationDTO, notification);


        // 获取接收通知的用户 ID
        Long toId = (notification.getCommentId() == null)
                ? postMapper.getUserId(notification.getPostId())
                : commentMapper.getUserId(notification.getCommentId());

        // 设置通知内容
        String content;
        if (Objects.equals(notification.getType(), NotificationConstant.LIKE)) {
            content = (notification.getCommentId() == null)
                    ? NotificationConstant.LIKE_POST_NOTIFICATION
                    : NotificationConstant.LIKE_COMMENT_NOTIFICATION;
        } else {
            content = (notification.getCommentId() == null)
                    ? NotificationConstant.COMMENT_NOTIFICATION
                    : NotificationConstant.REPLY_NOTIFICATION;
        }

        notification.setToId(toId);
        notification.setContent(content);

        notificationMapper.insert(notification);
        log.info("接收通知:{}", notification);
    }
}
