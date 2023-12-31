/*
 * Copyright (C) 2022 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.knife4j.demo.config;

import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.BuilderDefaults.nullToEmptyList;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/21 15:46
 */
public class HttpAuthenticationBuilder {
    private String name;
    private String description;
    private String scheme;
    private String bearerFormat;
    private final List<VendorExtension> extensions = new ArrayList<>();

    public HttpAuthenticationBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HttpAuthenticationBuilder scheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public HttpAuthenticationBuilder bearerFormat(String bearerFormat) {
        this.bearerFormat = bearerFormat;
        return this;
    }

    public HttpAuthenticationBuilder description(String description) {
        this.description = description;
        return this;
    }

    public HttpAuthenticationBuilder extensions(List<VendorExtension> extensions) {
        this.extensions.addAll(nullToEmptyList(extensions));
        return this;
    }

    public HttpAuthenticationScheme build() {
        return new HttpAuthenticationScheme(
                name,
                description,
                "http",
                scheme,
                bearerFormat,
                extensions);
    }
}
