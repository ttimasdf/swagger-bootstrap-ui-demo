/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.common.RestMessage;
import com.swagger.bootstrap.ui.demo.domain.ReqEntity;
import com.swagger.bootstrap.ui.demo.domain.ResponseList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/12/18 16:41
 */
@Api(value = "分组测试",tags = "分组测试")
@RestController
@RequestMapping("/api/group")
public class GroupController {

    @PostMapping("/xxx")
    @ApiOperation(value = "ModelAttribute",notes = "ModelAttribute类型参数",tags = {"测试用例","分组测试"})
    public RestMessage reqbody1(@ModelAttribute ReqEntity reqEntity){
        return new RestMessage(reqEntity);
    }
    @PostMapping("/reqbody2")
    @ApiOperation(value = "ModelAttribute",notes = "ModelAttribute类型参数")
    public RestMessage reqbody2(@ModelAttribute ReqEntity reqEntity){
        return new RestMessage(reqEntity);
    }

    @PostMapping("/responseListRest")
    @ApiOperation(value = "responseListRest",notes = "responseListRest类型参数",tags = {"测试用例","分组测试"})
    public Rest<ResponseList> responseListRest(){
        Rest<ResponseList> r=new Rest<>();

        ResponseList rl=new ResponseList();
        r.setData(rl);
        return r;


    }

}
