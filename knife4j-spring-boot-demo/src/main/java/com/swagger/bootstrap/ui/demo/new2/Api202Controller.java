/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.IgnoreP1;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/12/16 19:42
 */
@Api(tags = "2.0.2版本-20200226",position = 286)
@RestController
@RequestMapping("/api/nxew202")
public class Api202Controller {



    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "忽略参数值-Form类型")
    @PostMapping("/ex")
    public Rest<LongUser> findAll(LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }

    @ApiOperationSupport(ignoreParameters = {"ignoreLabels[0].code","longUser.ids"})
    @ApiOperation(value = "忽略参数值-Form类型1")
    @PostMapping("/ex1")
    public Rest<IgnoreP1> findAll12(IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }


    @ApiOperationSupport(ignoreParameters = "longUser.ids")
    @ApiOperation(value = "忽略参数值-JSON类型")
    @PostMapping("/ex2")
    public Rest<LongUser> findAll1(@RequestBody LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }

    @ApiOperationSupport(ignoreParameters = {"ignoreP1.ignoreLabels[0].code","ignoreP1.longUser.ids"})
    @ApiOperation(value = "忽略参数值-JSON类型1")
    @PostMapping("/ex3")
    public Rest<IgnoreP1> findAll3(@RequestBody IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }

    @ApiOperationSupport(ignoreParameters = "longUsers.ids")
    @ApiOperation(value = "忽略参数值-数组类型")
    @PostMapping("/ex4")
    public Rest<List<LongUser>> findAll4(@RequestBody List<LongUser> longUsers) {
        Rest<List<LongUser>> r=new Rest<>();
        r.setData(longUsers);
        return r;
    }

}
