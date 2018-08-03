/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.common.RestMessage;
import com.swagger.bootstrap.ui.demo.domain.Recipt;
import com.swagger.bootstrap.ui.demo.domain.ReqEntity;
import com.swagger.bootstrap.ui.demo.domain.SendUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/07/25 11:26
 */
@RestController
@Api("API注释")
@RequestMapping(value = "/api/aci")
public class ApiController {

    @PostMapping("/xxx")
    @ApiOperation(value = "ModelAttribute",notes = "ModelAttribute类型参数",tags = {"API注释","API自定义"})
    public RestMessage reqbody1(@ModelAttribute ReqEntity reqEntity){
        return new RestMessage(reqEntity);
    }



    @PostMapping("/sendUser")
    @ApiOperation(value = "用户注册",notes = "填写用户信息注册用户")
    public Rest<SendUserRequest> requestRest(@RequestBody SendUserRequest sendUserRequest){
        Rest<SendUserRequest> requestRest=new Rest<>();
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

    @PostMapping("/sendReciptUser")
    @ApiOperation(value = "用户注册sendReciptUser",notes = "填写用户信息注册用户sendReciptUser")
    public Rest<Recipt> sendReciptUser(@RequestBody Recipt recipt){
        Rest<Recipt> requestRest=new Rest<>();
        requestRest.setData(recipt);
        return requestRest;
    }

    @GetMapping("/sendUser1")
    @ApiOperation(value = "用户注册",notes = "填写用户信息注册用户")
    public Rest<SendUserRequest> requestGetRest(@ApiParam(value = "email") String email){
        Rest<SendUserRequest> requestRest=new Rest<>();
        SendUserRequest sendUserRequest=new SendUserRequest();
        sendUserRequest.setEmail(email);
        requestRest.setData(sendUserRequest);
        return requestRest;
    }

}
