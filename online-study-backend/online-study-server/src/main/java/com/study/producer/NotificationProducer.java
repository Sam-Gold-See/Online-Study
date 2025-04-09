package com.study.producer;

import com.study.constant.RabbitMQConstant;
import com.study.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送通知DTO对象到通知队列
     *
     * @param notificationDTO 通知DTO对象
     */
    public void sendNotificationDTO(NotificationDTO notificationDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConstant.NOTIFICATION_EXCHANGE,
                RabbitMQConstant.NOTIFICATION_ROUTING_KEY,
                notificationDTO);
    }
}
