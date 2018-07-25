/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.common.RestMessage;
import com.swagger.bootstrap.ui.demo.domain.ReqEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
