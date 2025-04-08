package com.study.consumer;

import com.study.constant.RabbitMQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConstant.NOTIFICATION_QUEUE)
    public void receiveNotification(String message) {
        log.info("receive consumer : {}", message);
    }
}
