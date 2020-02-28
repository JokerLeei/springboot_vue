/*
package com.example.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

*/
/**
 * 配置多数据源。
 *//*

*/
/*@Configuration*//*

public class DataSourceConfig {
    // 加载配置文件前缀为 ds.one 的自定义配置信息。bean 名默认为方法名dsOne
    @Bean
    @ConfigurationProperties("ds.one")
    DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    // 加载配置文件前缀为 ds.two 的自定义配置信息
    @Bean
    @ConfigurationProperties("ds.two")
    DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
*/
