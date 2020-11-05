package com.aloli.config.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {

    //指定客户端收到的http状态码  这里配置500错误  客户端就显示500错误
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //统一处理某一类异常  从而能够减少代码重复率和复杂度
    //这里指的是处理Throwable异常
    @ExceptionHandler(Throwable.class)
    public String  handleThrowable(Throwable e , HttpServletRequest  request){
    System.out.print("aaaxxx");
    return "dd";
    }

}
