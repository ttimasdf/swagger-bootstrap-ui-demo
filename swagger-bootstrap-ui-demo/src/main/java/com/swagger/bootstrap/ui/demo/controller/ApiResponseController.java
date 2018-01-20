/*
 * Copyright (C) 2017 Zhejiang lishiots Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.lishiots.com.
 * Developer Web Site: http://open.lishiots.com.
 */

package com.swagger.bootstrap.ui.demo.controller;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.ReqEntity;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/01/20 13:56
 */
@RestController
@RequestMapping("/api/response")
public class ApiResponseController {

    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
                @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
                 })
    @PostMapping("/obj")
    public Rest<ReqEntity> obj(){
        ReqEntity reqEntity=new ReqEntity();
        Rest<ReqEntity> reqEntityRest=new Rest<>();
        reqEntityRest.setData(reqEntity);
        return reqEntityRest;
    }
}
