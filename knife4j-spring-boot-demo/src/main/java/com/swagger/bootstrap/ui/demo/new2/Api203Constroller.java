/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import com.swagger.bootstrap.ui.demo.domain.resp202.KDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/12 9:04
 */
@Api(tags = "2.0.3版本-20200312",position = 285)
@RestController
@RequestMapping("/api/nxew203")
public class Api203Constroller {


    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "GET请求参数出现NULL的情况")
    @GetMapping("/ex")
    public Rest<LongUser> findAll(LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }

    @ApiOperation(value = "忽略参数")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers"})
    @GetMapping("/getUser221")
    public Rest<KDto> getUse1rx(KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }

}
