/*
package com.example.config.jms;

import com.example.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.DirectReceiver;

import javax.jms.Queue;

// 配置 JMS，完成消息的发送和接受
@DirectReceiver
public class JmsComponent {
    // Spring 提供的一个 JMS 消息发送模板
    @Autowired
    JmsMessagingTemplate messagingTemplate;

    @Autowired
    Queue queue;

    public void send(Message msg) {
        // convertAndSend
        // 第一个个参数 queue：消息队列
        // 第二个参数 msg：消息内容
        messagingTemplate.convertAndSend(this.queue, msg);
    }

    // @JmsListener 注解表示 receive 方法是一个消息消费者，消息消费者订阅的消息 destination 为 amq
    @JmsListener(destination = "amq")
    public void receive(Message msg) {
        System.out.println("receive:" + msg);
    }
}
*/
