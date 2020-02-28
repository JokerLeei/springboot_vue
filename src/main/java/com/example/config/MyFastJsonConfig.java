/*
package com.example.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

*/
/**
 * 自定义 MyFastJsonConfig，完成对 FastJsonHttpMessageConverter Bean 的提供。
 *//*

*/
/*@Configuration*//*

public class MyFastJsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        // JSON 日期格式
        config.setDateFormat("yyyy-MM-dd");
        // JSON 数据编码
        config.setCharset(Charset.forName("UTF-8"));
        config.setSerializerFeatures(
                // 在生成的JSON中输出类名
                SerializerFeature.WriteClassName,
                // 输出value为null的数据
                SerializerFeature.WriteMapNullValue,
                // 生成的JSON格式化
                SerializerFeature.PrettyFormat,
                // 空集合输出[]而非null
                SerializerFeature.WriteNullListAsEmpty,
                // 空字符串输出""而非null
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(config);
        return converter;
    }
}
*/
