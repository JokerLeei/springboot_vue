package com.example.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局数据处理
 */
@ControllerAdvice
public class GlobalConfig {

    /**
     * 在全局配置中添加 userInfo 方法，返回一个map。
     * 该方法的注解 @ModelAttribute 的 value 属性表示这条返回数据的key，而方法的返回值是返回数据的value
     *
     * 此时在任意请求的Controller中，通过方法参数中的Model都可以获取info的数据
     */
    @ModelAttribute(value = "info")
    public Map<String,String> userInfo(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username","罗贯中");
        map.put("gender","男");
        return map;
    }

    /**
     * 处理@ModelAttribute("b")对应的参数
     *
     * binder对象还能设置允许的字段、禁止的字段、必填字段以及验证器等
     */
    @InitBinder("b")
    public void init(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }

    /**
     * 处理@ModelAttribute("a")对应的参数
     */
    @InitBinder("a")
    public void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }
}
