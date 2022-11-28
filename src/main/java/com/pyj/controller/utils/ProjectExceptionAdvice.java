package com.pyj.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 作为springMVC的异常处理器（dao层和service层发生异常，最终也会抛到controller）
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        // 记录日志
        // 通知运维
        // 通知开发
        ex.printStackTrace(); //拦截异常后记得需要打印异常，否则出什么错都不知道
        return new R("服务器故障，请稍后重试！");
    }
}
