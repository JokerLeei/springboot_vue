package com.example.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 全局异常处理
 */
@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("上传文件大小超出限制！");
        out.flush();
        out.close();
    }

    /*@ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e){
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error",e.getMessage());
        return mv;
    }*/
}
