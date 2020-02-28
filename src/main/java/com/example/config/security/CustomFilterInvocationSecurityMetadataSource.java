/*
package com.example.config.security;

import com.example.mapper.MenuMapper;
import com.example.model.Menu;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.DirectReceiver;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

// 动态配置权限
@DirectReceiver
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    // 创建一个 AntPathMatcher，主要用来实现 ant 风格的 URL 匹配
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    MenuMapper menuMapper;

    // 这个方法的参数是一个 FilterInvocation，开发者可以从中提取出当前请求的 URL，方法返回值表示当前请求 URL 所需的角色
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 从参数中提取出当前请求的 URL
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // 从数据库中获取所有的资源信息，即本案例中的 menu 表以及 menu 所对应的 role
        // 在真实项目环境中，开发者可以将资源信息缓存在 Redis 或者其他缓存数据库中
        List<Menu> allMenus = menuMapper.getAllMenus();
        // 遍历资源信息，遍历过程中获取当前请求的 URL 所需要的角色信息并返回，如果当前请求的 URL 在资源表中不存在相应的模式，就假设
        // 该请求登录后即可访问，即直接返回 ROLE_LOGIN
        for (Menu menu : allMenus) {
            if (antPathMatcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleArr = new String[roles.size()];
                for (int i = 0; i < roleArr.length; i++) {
                    roleArr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    // getAllConfigAttributes 方法用来返回所有定义好的权限资源，Spring Security 在启动时会校验相关配置是否正确，如果不需要校验，
    // 那么该方法直接返回 null 即可
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    // supports 方法返回类对象是否支持校验
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
*/
