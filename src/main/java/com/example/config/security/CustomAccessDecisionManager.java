/*
package com.example.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.DirectReceiver;

import java.util.Collection;

@DirectReceiver
public class CustomAccessDecisionManager implements AccessDecisionManager {

    // 在 decide 方法中判断当前登录的用户是否具备当前请求 URL 所需要的角色信息
    // 如果不具备，抛出AccessDeniedException异常，否则不做任何事即可
    // 这个方法的三个参数：
    // auth：当前登录用户的信息
    // object：FilterInvocation 对象，可以获取当前请求对象等
    // ca：即FilterInvocationSecurityMetadataSource 中的 getAttributes 方法的返回值，即当前请求 URL 所需要的角色
    @Override
    public void decide(Authentication auth,
                       Object object,
                       Collection<ConfigAttribute> ca)
            throws AccessDeniedException, InsufficientAuthenticationException {
        // 进行角色信息对比，如果需要的角色是 ROLE_LOGIN，说明当前请求的 URL 用户登录后即可访问
        // 如果 auth 是 UsernamePasswordAuthenticationToken 的实例，那么说明当前用户已登录，该方法到此结束，否则进入正常判断流程
        // 如果当前用户具备当前请求需要的角色，那么方法结束
        Collection<? extends GrantedAuthority> auths = auth.getAuthorities();
        for(ConfigAttribute configAttribute:ca){
            if("ROLE_LOGIN".equals(configAttribute.getAttribute()) && auth instanceof UsernamePasswordAuthenticationToken){
                return;
            }
            for(GrantedAuthority authority:auths){
                if(configAttribute.getAttribute().equals(authority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
*/
