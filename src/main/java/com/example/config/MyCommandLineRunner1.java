package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 启动系统任务(配置文件加载、数据库初始化等)
 *
 * 非Spring boot项目使用Listener
 * spring boot项目：
 *      1.CommandLineRunner (@Order注解值越小越优先)
 *      2.ApplicationRunner
 */
/*@DirectReceiver*/
@Order(1)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner1>>>"+ Arrays.toString(args));
    }
}
