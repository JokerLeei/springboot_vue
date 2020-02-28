/*
package com.example.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// RabbitMQ Exchange 策略 1 Direct
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "sang-direct";

    // 提供一个消息队列 Queue
    @Bean
    Queue queue() {
        return new Queue("hello-queue");
    }

    // 创建一个 DirectExchange 对象
    // 参数1：名字
    // 参数2：重启后是否依然有效
    // 参数3：长期未用时是否删除
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}
*/
