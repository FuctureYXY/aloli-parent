package com.aloli.config.res;

import com.alibaba.fastjson.JSONObject;
import com.aloli.util.R;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



//全局返回处理器

//配置 只对这些路径下的返回生效  res 是为了扫描到异常
@RestControllerAdvice(basePackages = {"com.aloli.*.controller","com.aloli.config.res"})
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
