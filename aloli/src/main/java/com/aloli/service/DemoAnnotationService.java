package com.aloli.service;

import com.aloli.annotation.aop.Action;

import java.util.List;

public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){}

}

