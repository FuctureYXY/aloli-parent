package com.aloli.annotation.aop;

import java.lang.annotation.*;
//拦截规则的注解
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Action {
    String name();
}
