package com.aloli.config.base;

import com.aloli.util.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {


    //已测试 处理异常过程    从范围小的 开始冒泡    并且 匹配到哪个就是哪个


    //指定客户端收到的http状态码  这里配置500错误  客户端就显示500错误

    //统一处理某一类异常  从而能够减少代码重复率和复杂度
    //这里指的是处理Throwable异常
    @ExceptionHandler(BussinessException.class)
    public ErrorResult handleBussinessException(BussinessException e , HttpServletRequest  request){
    ErrorResult errorResult = ErrorResult.builder()
            .status(e.code)
            .message(e.message)
            .errors("程序控制异常")
            .exception(e.getClass().getName())
            .build();
    return errorResult;
    }

    //全局控制异常 throwable.class(顶级)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e , HttpServletRequest  request){
        ErrorResult errorResult = ErrorResult.builder()
                .status(500)
                .message(e.getMessage())
                .errors("非程序控制异常")
                .exception(e.getClass().getName())
                .build();
        return errorResult;
    }
}
