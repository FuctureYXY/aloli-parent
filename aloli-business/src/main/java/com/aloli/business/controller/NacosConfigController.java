package com.aloli.business.controller;

import com.aloli.business.netty.NettyClient;
import com.aloli.security.api.RemoteSecurityFeign;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
@RefreshScope
@AllArgsConstructor
public class NacosConfigController {

    private RemoteSecurityFeign remoteSecurityFeign;
    private NettyClient nettyClient;


    @RequestMapping("/get")
    public List get() {
       return  remoteSecurityFeign.getList();
    }

    @RequestMapping("/get2")
    public String get2() {
        throw new RuntimeException("vv");
    }

    @RequestMapping("/get3")
    public void get3() {
       nettyClient.sendMsg("bbaa");
    }
}
