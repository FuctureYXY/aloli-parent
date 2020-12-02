package com.aloli.oauth2.gateway.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private static final List<String> ignoeUrl = new ArrayList<>();

    @PostConstruct
    public void add() {
        ignoeUrl.add("/oauth/token");
        ignoeUrl.add("/oauth/authorize");
        ignoeUrl.add("/oauth/check_token");
        ignoeUrl.add("/login");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();
        Mono<Void> mono = null;
        if (ignoeUrl.contains(path)) {
            mono = chain.filter(exchange);
        } else {
            String authorization = exchange.getRequest().getHeaders().getFirst("Authorization");
            String access_token = exchange.getRequest().getQueryParams().getFirst("access_token");
            if (StringUtils.isBlank(authorization) && StringUtils.isBlank(access_token)) {
                throw new RuntimeException("tokenMissing");
            }
            if (StringUtils.isNotBlank(authorization)) {
                String bearer = authorization.replace("Bearer", "").trim();
                if (StringUtils.isBlank(bearer)) {
                    throw new RuntimeException("tokenMissing");
                }
            }
            mono = chain.filter(exchange);
        }
        return mono;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
