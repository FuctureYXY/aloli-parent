package com.aloli.security.service;

import com.aloli.annotation.aop.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){
        System.out.println("aa");
        test();
    }

    public void  test(){
        System.out.println("bb");
    }

}

