/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package com.swagger.bootstrap.ui.demo.controller;

import com.swagger.bootstrap.ui.demo.common.RestMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/08/10 14:47
 */
@Api(value = "测试C",tags = "测试C")
@RequestMapping("/api/testc")
@RestController
public class TestcController {

    @PostMapping("/selectLog")
    @ApiOperation(value = "selectLog",notes = "selectLog")
    public RestMessage selectLog(@RequestBody Map<String,Object> infoMap,
                                 @RequestAttribute(name = "CURRENTUSERID" ) int userId){
        return new RestMessage(infoMap);
    }
}
