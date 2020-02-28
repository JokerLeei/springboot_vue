/*
package com.example.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// RabbitMQ exchange 策略 3 Topic
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME="sang-topic";

    // 首先创建 TopicExchange
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }

    // 创建三个 Queue，第一个Queue存储和 xiaomi 相关的信息，第二个存 huawei 相关的信息，第三个 phone 信息
    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei(){
        return new Queue("huawei");
    }

    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    // 将三个 Queue 分别绑定到 TopicExchange 上
    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                // ↓ 表示凡是以 xiaomi 开头的都被路由到名称为 xiaomi 的 Queue 上
                .with("xiaomi.#");
    }

    @Bean
    Binding huaweiBinding(){
        return BindingBuilder.bind(huawei()).to(topicExchange())
                // ↓ 表示凡是以 huawei 开头的都被路由到名称为 huawei 的 Queue 上
                .with("huawei.#");
    }

    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange())
                // ↓ 表示凡是包含 phone 开头的都被路由到名称为 phone 的 Queue 上
                .with("#.phone.#");
    }
}
*/
