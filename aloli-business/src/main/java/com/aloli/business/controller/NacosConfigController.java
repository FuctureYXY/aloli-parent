package com.aloli.business.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class NacosConfigController {



    @RequestMapping("/get")
    public String get() {
       throw new RuntimeException("vv");
    }
    @RequestMapping("/get2")
    public String get2() {
        throw new RuntimeException("vv");
    }
}
