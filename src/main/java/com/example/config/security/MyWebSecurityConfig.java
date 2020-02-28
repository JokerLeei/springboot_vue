/*
package com.example.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

// 自定义 安全配置
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        // 密码加密方式，NoOpPasswordEncoder为不对密码进行加密
        */
/*return NoOpPasswordEncoder.getInstance();*//*

        // Spring Security 推荐的密码加密方案 BCryptPasswordEncoder，默认构造参数为10(密钥迭代次数，2^10)
        return new BCryptPasswordEncoder(10);
    }

    // 基于内存的认证(写死的账户)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                */
/*.withUser("root")
                .password("123")
                .roles("ADMIN", "DBA")
                .and()*//*

                .withUser("admin")
                .password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq")
                .roles("ADMIN", "USER")
                .and()
                .withUser("sang")
                .password("$2a$10$eUHbAOMq4bpxTvOVz33LIehLe3fu6NwqC9tdOcxJXEhyZ4simqXTC")
                .roles("USER");
    }

    // HttpSecurity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 访问 /user/** 模式的url 必须具备 ADMIN 或 USER 的角色，其他以此类推
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")

                // 下面两行：除了前面定义的 URL 模式之外，用户访问其他的 URL 都必须认证后访问(登录后访问)
                .anyRequest()
                .authenticated()


                .and()
                .formLogin()
                // 配置登录页面，如果用户未获授权就访问一个需要授权才能访问的接口，就会自动跳转到login_page让用户登录，
                // 这个login_page是开发者自定义的登录页面，而非 Spring Security 提供的默认登录页
                */
/*.loginPage("/login_page")*//*


                // 开启表单登录，配置登录接口为 /login
                // 即可以直接调用 /login 接口，发起一个POST请求进行登录
                // 登录请求处理接口，无论是自定义登录页面还是移动端登录，都需要使用该接口
                .loginProcessingUrl("/login")
                // 认证所需用户名和密码的参数名，默认为 username + password，这里可以自定义
                .usernameParameter("name")
                .passwordParameter("passwd")

                // 登录成功的处理逻辑，登录成功可以跳转某一页面，也可以返回一段 JSON
                // Authentication authentication 参数用于获取当前登录用户得信息
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication authentication)
                            throws IOException, ServletException {
                        Object principal = authentication.getPrincipal();
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        resp.setStatus(200);
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 200);
                        map.put("msg", principal);
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })

                // 登录失败的处理逻辑
                // 和登陆成功不同的是有个 AuthenticationException e，用于获取登录失败的原因，进而给用户一个明确提示
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        AuthenticationException e)
                            throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        resp.setStatus(401);
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 401);
                        if (e instanceof LockedException) {
                            map.put("msg", "账户被锁定，登录失败！");
                        } else if (e instanceof BadCredentialsException) {
                            map.put("msg", "账户名或密码输入错误，登陆失败！");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "账户被禁用，登录失败！");
                        } else if (e instanceof AccountExpiredException) {
                            map.put("msg", "账户已过期，登陆失败！");
                        } else if (e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码已过期，登录失败！");
                        } else {
                            map.put("msg", "登陆失败！");
                        }
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                // 和登录相关的接口都不需要认证即可访问
                .permitAll()

                // 注销登录配置
                .and()
                // 开启注销登录的配置
                .logout()
                // 配置注销登录请求URL为 /login，默认也是 /login
                .logoutUrl("/logout")
                // 是否清除身份认证信息，默认为true，表示清除
                .clearAuthentication(true)
                // 是否使 Session 失效，默认为true
                .invalidateHttpSession(true)
                // 配置一个 LogoutHandler，在这里可以完成一些数据清除工作，如Cookie清除
                // SpringSecurity已经提供了一些常见的实现，或者自定义个匿名内部类
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest req,
                                       HttpServletResponse resp,
                                       Authentication authentication) {
                    }
                })
                // 配置一个 LoginoutSuccessHandler，处理注销成功后的业务逻辑，例如返回一段JSON或者页面跳转等
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req,
                                                HttpServletResponse resp,
                                                Authentication authentication)
                            throws IOException, ServletException {
                        resp.sendRedirect("/login_page");
                    }
                })
                .and()

                .csrf()
                .disable();
    }
}
*/
