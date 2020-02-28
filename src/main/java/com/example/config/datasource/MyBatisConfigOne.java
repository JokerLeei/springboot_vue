/*
package com.example.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

*/
/**
 * MyBatis 多数据源配置。
 *
 * 主要提供 SqlSessionFactory 实例和 SqlSessionTemplate 实例。
 *//*

@Configuration
@MapperScan(value = "com.example.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MyBatisConfigOne {
    @Autowired
    @Qualifier("dsOne")
    DataSource dsOne;

    */
/*
        提供 SqlSessionFactory 的实例，直接创建出来，同时将 DataSource 的实例设置给 sqlSessionFactory，
        这里创建的 SqlSessionFactory 实例也就是 @MapperScan 注解中 sqlSessionFactoryRef 参数指定的实例。
    *//*

    @Bean
    SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsOne);
        return factoryBean.getObject();
    }

    */
/*
        提供一个 SqlSessionTemplate 实例。这是一个线程安全类，主要用来管理 MyBatis 中的 SqlSession 操作。
    *//*

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }
}
*/
