/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/25 9:20
 * @since:knife4j-spring-boot-demo 1.0
 */
/*@Configuration
@EnableAuthorizationServer*/
@Order(404)
public class AuthConfiguration extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final NoOpPasswordEncoder noOpPasswordEncoder;

    public AuthConfiguration(AuthenticationManager authenticationManager, NoOpPasswordEncoder noOpPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.noOpPasswordEncoder = noOpPasswordEncoder;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //授权码模式（authorization code）
        //简化模式（implicit）
        //密码模式（resource owner password credentials）
        //客户端模式（client credentials）

        clients.inMemory()
            .withClient("app1").secret(noOpPasswordEncoder.encode("123"))
                //.authorizedGrantTypes("implicit")
                //.authorizedGrantTypes("authorization_code")
                //.authorizedGrantTypes("password")
                .authorizedGrantTypes("client_credentials")
                .redirectUris("http://localhost:8999/data/callback",
                        "http://localhost:8999/webjars/springfox-swagger-ui/oauth2-redirect.html",
                        "http://192.168.1.10:8080/oauth/oauth2.html",
                        "http://localhost:8999/webjars/oauth/oauth2.html")
                .scopes("read","write","reads","writes");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }
}
