/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.grn.MapInfo;
import com.swagger.bootstrap.ui.demo.grn.SessionContentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/06/25 22:59
 */
@Api(tags = "2.0.4版本-20200620")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 284)
@RestController
@RequestMapping("/api/nxew204")
public class Api204Controller {

    @ApiOperation(value = "针对实体类Map字段包含类本身的Value指引")
    @GetMapping("/getInfo")
    public Rest<MapInfo> getInfo(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }

    @ApiOperation(value = "针对Map复杂类型的情况无法显示字段")
    @GetMapping("/getMapInfo")
    public Rest<SessionContentResponse> getMapInfo(){
        Rest<SessionContentResponse> responseRest=new Rest<>();
        SessionContentResponse sessionContentResponse=new SessionContentResponse();
        sessionContentResponse.setRespTime(String.valueOf(System.currentTimeMillis()));
        responseRest.setData(sessionContentResponse);
        return responseRest;
    }
}
