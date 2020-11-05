package com.aloli.config.base;

import com.alibaba.fastjson.JSONObject;
import com.aloli.util.R;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



//配置 只对这个包下面的controller生效
@RestControllerAdvice(basePackages = {"com.aloli.controller","com.aloli.config.base"})
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    //是否支持advice的功能   true  支持  false 不支持
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {




        return true;

    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {


        if(body instanceof  String){

            return JSONObject.toJSONString(new R(body));
        }


        return new R(body);

    }

}
