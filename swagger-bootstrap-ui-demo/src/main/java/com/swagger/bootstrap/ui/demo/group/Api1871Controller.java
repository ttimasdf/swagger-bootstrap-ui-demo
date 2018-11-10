/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.lianqu1990.springboot.web.version.mapping.annotation.ApiVersion;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp187.Model187;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/***
 * 1.8.6fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/05 08:44
 */
@Api(tags = "1.8.71版本-20181105",position = 298)
@RestController
@RequestMapping
public class Api1871Controller {

    @ApiOperation(value = "版本2-post请求参数Hidden属性是否生效",position = 30)
    @PostMapping("/postRequest")
    @ApiVersion("2")
    public Rest<Model187> postRequest(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }


    @ApiOperation(value = "版本1-post请求参数Hidden属性是否生效",position = 2)
    @PostMapping("/postRequest")
    public Rest<Model187> postRequest1(@RequestBody Model187 model187){
        Rest<Model187> r=new Rest<>();
        r.setData(model187);
        return r;
    }
}