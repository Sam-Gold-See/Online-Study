package com.study.config;

import com.study.constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * 注册一个Direct类交换机，负责notification相关业务
     */
    @Bean
    public DirectExchange notificationExchange() {
        return new DirectExchange(RabbitMQConstant.NOTIFICATION_EXCHANGE);
    }

    /**
     * 注册一个持久化队列，负责notification相关业务
     */
    @Bean
    public Queue notificationQueue() {
        return new Queue(RabbitMQConstant.NOTIFICATION_QUEUE, true);
    }

    /**
     * 绑定队列到交换机，并且指定 RoutingKey
     *
     * @param notificationQueue    要绑定的队列
     * @param notificationExchange 要绑定的交换机
     */
    @Bean
    public Binding bindingNotification(Queue notificationQueue, DirectExchange notificationExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(notificationExchange)
                .with(RabbitMQConstant.NOTIFICATION_ROUTING_KEY);
    }
}
