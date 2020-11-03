package com.aloli.service;

import com.aloli.annotation.aop.Action;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){
        System.out.println("aa");
    }

}

