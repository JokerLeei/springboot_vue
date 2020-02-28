/*
package com.example.config.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// RabbitMQ 的 Direct 策略，配置一个消费者
@Component
public class DirectReceiver {
    // @RabbitListener 注解指定一个方法时一个消息消费方法
    // 方法参数是所接受到的消息
    @RabbitListener(queues = "hello-queue")
    public void handler1(String msg){
        System.out.println("DirectReceiver:"+msg);
    }
}
*/
