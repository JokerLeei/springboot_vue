package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring boot 推荐使用java类配置。而不是xml
 *
 * Spring boot 中对于 Spring MVC 最基本的配置由 WebMvcConfigurer 提供
 * 如果基本配置不满足需求，可以自定义类实现 WebMvcConfigurer 中某个方法。
 * (Spring5.0之前通过继承 WebMvcConfigurerAdapter类实现)
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    /**
     * CORS(跨域资源共享) 全局配置
     *
     * 自定义类 MyWebMvcConfig 实现 WebMvcConfigurer 接口中的 addCorsMappings方法
     *
     * 方法 1(细粒度，见controller/BookController，使用@CorsOrigin注解)
     * 方法 2 全局配置 ↓
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
            addMapping：对哪种格式的请求路径进行跨域处理
            alloweHeaders：允许的请求头。默认允许所有请求头信息
            allowedMethods：允许的请求方法。默认为GET、POST、HEAD，*表示支持所有方法
            maxAge：探测请求的有效期
            allowedOrigins：支持的域
        */
        registry.addMapping("/book/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:8081");
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
            addInterceptor：添加自定义的拦截器
            addPathPathPatterns：拦截路径
            excludePathPatterns：排除路径(不拦截的路径)
        */
        /*registry.addInterceptor(new MyInterceptor1())
                .addPathPatterns("/**")
                .excludePathPatterns("/hello");*/
    }

    /**
     * 路径映射
     *
     * 一般使用页面模板后，用户需要通过Controller才能访问页面
     *
     * 一些页面要在Controller中加载数据，然后渲染，才能显示出来
     * 还有一些页面只是完成简单的跳转，不需要Controller加载数据，对于这些页面，可以直接配置路径映射，提高访问速度
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        /*registry.addViewController("/login").setViewName("login");
        registry.addViewController("/unauthorized").setViewName("unauthorized");*/
    }

    /**
     * 修改自定义消息转换器
     * @param converters 消息转换器列表
     */
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //升级最新版本需加=============================================================
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        *//*supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);*//*
        supportedMediaTypes.add(MediaType.ALL);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);

        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        //WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
        //WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
        //DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
        //WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
        //WriteMapNullValue：是否输出值为null的字段,默认为false
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }*/
}
