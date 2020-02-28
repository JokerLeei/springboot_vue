package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
// 整合 Servlet、Filter、Listener
/*@ServletComponentScan*/
// 开启缓存
@EnableCaching
public class SpringbootVueApplication {
    public static void main(String[] args) {
        // 关闭启动 springboot 时的banner
        /*SpringApplicationBuilder builder=new SpringApplicationBuilder(SpringbootVueApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);*/
        SpringApplication.run(SpringbootVueApplication.class, args);
    }

    /*@Bean
    Queue queue(){
        return new ActiveMQQueue("amq");
    }*/
}

