package com.study.consumer;

import com.study.constant.RabbitMQConstant;
import com.study.dto.NotificationDTO;
import com.study.entity.Notification;
import com.study.mapper.NotificationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitMQConstant.NOTIFICATION_QUEUE)
public class NotificationConsumer {

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

        notificationMapper.insert(notification);
    }
}
