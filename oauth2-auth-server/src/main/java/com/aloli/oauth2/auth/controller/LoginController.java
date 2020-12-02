package com.aloli.oauth2.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("getOrder")
    public String getOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("用户信息:{}",authentication);
        return "获取订单成功";
    }
}
