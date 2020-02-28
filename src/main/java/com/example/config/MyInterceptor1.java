package com.example.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册拦截器
 *
 * 执行顺序：preHandle → Controller → postHandle → afterCompletion
 *
 * 注意：
 *      只有 preHandle 方法返回 true 时后面的方法才会执行。
 *      当拦截器链内存在多个拦截器时，postHandler在拦截器链内的所有拦截器返回成功时才会调用，
 *      而 afterCompletion 只有 preHandle 返回 true 才调用，
 *      但若拦截器链内的第一个拦截器的 preHandle 方法返回 false ，则后面的方法都不会执行
 */
public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("MyInterceptor1>>>preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1>>>postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("MyInterceptor1>>>afterCompletion");
    }
}
