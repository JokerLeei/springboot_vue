package com.example.config.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 完全自定义(自定义错误信息 + 自定义错误视图)
 *
 * 继承自 BasicErrorController
 *
 * 自定义 MyErrorController 继承自 BasicErrorController 并添加 @Controller 注解，将 MyErrorController 注册到 SpringMVC容器中。
 */
@Controller
public class MyErrorController extends BasicErrorController {

    /**
     * 由于BasicErrorController 没有无参构造方法，因此在创建 BasicErrorController 实例时需要传递参数，
     * 在 MyErrorController 的构造方法上添加 @Autowired 注解注入所需参数
     */
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes,
                             ServerProperties serverProperties,
                             List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }


    // 参考 BasicErrorController 中的实现，重写 errorHtml 和 error 方法，对Error的视图和数据进行充分自定义
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        model.put("custommsg", "出错啦！");
        // reources/templates 目录下提供 myErrorPage.html页面作为视图页面
        return new ModelAndView("myErrorPage", model, status);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        body.put("custommsg", "出错啦！");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }
}
