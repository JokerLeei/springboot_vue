/*
package com.example.config.security;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    // Realm 可以是自定义 Realm，也可以是 Shiro 提供的 Realm
    // 简单起见，这里没有配数据库，直接写死两个账户，sang/123 admin/123，以及他们的权限
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }

    // 这个Bean配置了基本的过滤规则
    // /login 和 /doLogin 可以匿名访问，/logout 是一个注销登录请求，其余请求则都需要认证后才能访问
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc");
        return chainDefinition;
    }

    // 为了在 Thymeleaf 中使用 Shiro
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
*/
