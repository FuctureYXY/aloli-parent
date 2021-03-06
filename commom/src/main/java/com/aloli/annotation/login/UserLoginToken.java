package com.aloli.annotation.login;
//需要登录才能进行操作的注解UserLoginToken
import java.lang.annotation.*;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}
