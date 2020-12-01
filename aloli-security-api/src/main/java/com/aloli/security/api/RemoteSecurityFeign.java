package com.aloli.security.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("aloli-security")
public interface RemoteSecurityFeign {
    @GetMapping("/login/getList")
    List getList();
}
