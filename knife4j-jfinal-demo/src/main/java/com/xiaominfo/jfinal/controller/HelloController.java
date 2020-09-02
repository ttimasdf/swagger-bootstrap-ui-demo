/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.jfinal.controller;

import com.jfinal.core.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/01 20:07
 * @since:knife4j-jfinal-demo 1.0
 */
@Api(tags = "测试")
public class HelloController extends Controller {

    @ApiOperation(value = "欢迎语")
    public void index(){
        renderText("Hello");
    }
}
