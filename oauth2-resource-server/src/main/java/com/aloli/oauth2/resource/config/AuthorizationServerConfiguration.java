package com.aloli.oauth2.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * https://blog.csdn.net/csdnmuyi/article/details/107336549
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        //使用redis 存储token   内部实现  存入redis
        return new RedisTokenStore(redisConnectionFactory);
        // return new JdbcTokenStore(dataSource);
    }

    /**
     * 使用数据库存储第三方信息(客户端信息), 比如我们自己写的前端页面,对于认证系统来说也称之为第三方
     * 会有个专门的表与之对应
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 关于token的详细配置
     * @return
     */
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setClientDetailsService(clientDetailsService());
        //access_token 的有效期,如果数据库中配置了的话,会覆盖该值,如果想通过数据库的值来覆盖下面这俩值的话
        //需要有上面的这一行配置defaultTokenServices.setClientDetailsService(clientDetailsService()),否则无法覆盖
        defaultTokenServices.setAccessTokenValiditySeconds(60 * 60);// 一小时
        //refresh_token 的有效期,如果数据库中配置了的话,会覆盖该值
        defaultTokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//7天
        //是否支持返回refresh_token,false 将不会返回refresh_token
        defaultTokenServices.setSupportRefreshToken(true);
        //对应上面的token存储配置
        defaultTokenServices.setTokenStore(tokenStore());

        return defaultTokenServices;
    }

    /**
     * 用来配置授权以及令牌的访问端点和令牌服务
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenServices(defaultTokenServices());
        //密码模式下 该配置必须有
        endpoints.authenticationManager(authenticationManager);
    }

    /**
     * 用来配置客户端详情信息,  也就是第三方,比如我们的自己的前端页面,app
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());

    }

    /**
     * 用来配置令牌断点的安全约束
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()").allowFormAuthenticationForClients();
    }
}
