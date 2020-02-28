/*
package com.example.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// RabbitMQ Exchange 策略 2 Fanout
@Configuration
public class RabbitFanoutConfig {
    public final static String FANOUTNAME="sang-fanout";

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUTNAME,true,false);
    }

    @Bean
    Queue queueOne(){
        return new Queue("queue-one");
    }

    @Bean
    Queue queueTwo(){
        return new Queue("queue-two");
    }

    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
*/
