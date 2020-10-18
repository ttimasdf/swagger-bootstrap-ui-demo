/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/18 11:04
 * @since:knife4j-spring-boot2-demo 1.0
 */
@EnableOpenApi
@EnableKnife4j
@Configuration
public class Knife4jConfig {

    @Bean(value = "defaultApi3")
    public Docket defaultApi3() {
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("3.测试分组")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xiaominfo.knife4j.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean(value = "defaultApi1")
    public Docket defaultApi1() {
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("1.2.x")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xiaominfo.knife4j.new2"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.2.x")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xiaominfo.knife4j.group"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui很棒~~~！！！")
                .description("swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.group.com/")
                .contact(new Contact("八一菜刀","http://gitee.com/xiaoymin","xiaoymin@foxmail.com"))
                .version("1.0")
                .build();
    }
}
