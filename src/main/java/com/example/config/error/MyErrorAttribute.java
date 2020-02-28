package com.example.config.error;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义 Error 数据
 *
 * 继承 DefaultErrorAttributes
 *
 * 自定义 MyErrorAttribute 继承自 DefaultErrorAttributes，重写 DefaultErrorAttributes 中的 getErrorAttributes 方法。
 * MyErrorAttribute 类添加@Component注解，该类将被注册到Spring容器中
 */
/*@DirectReceiver*/
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        // super.getErrorAttributes获取Spring Boot默认提供的错误信息，然后再次基础上添加Error信息或者移除Error信息
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("custommsg", "出错啦");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}
