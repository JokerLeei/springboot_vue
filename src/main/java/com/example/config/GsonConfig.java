/*
package com.example.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

*/
/**
 * Spring boot 中默认提供了 Gson 的自动转换类 GsonHttpMessageConvertersConfiguration
 * 这个类有个注解 @ConditionalOnMissingBean。
 * 即当没有自定义的 GsonHttpMessageConverter 时这个默认的才会有效
 * 所以下面这个是自定义的 GsonHttpMessageConverter，来覆盖默认那个
 *//*

@Configuration
public class GsonConfig {
    // 开发者自己提供一个 GsonHttpMessageConverter 的实例
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();
        // 设置 Gson 解析时日期的格式
        builder.setDateFormat("yyyy-MM-dd");
        // 设置 Gson 解析时修饰符为 protected 的字段被过滤掉
        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        // 创建 Gson 对象对象放入 GsonHttpMessageConverter 的实例中并返回 converter
        Gson gson = builder.create();
        converter.setGson(gson);
        return converter;
    }
}
*/
