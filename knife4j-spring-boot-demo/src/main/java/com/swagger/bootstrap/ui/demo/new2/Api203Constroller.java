/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.LongUser;
import com.swagger.bootstrap.ui.demo.domain.resp202.KDto;
import com.swagger.bootstrap.ui.demo.domain.resp202.KDtoInfo;
import com.swagger.bootstrap.ui.demo.domain.resp202.KDtoObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/12 9:04
 */
@Api(tags = "2.0.3版本-20200312",position = 285)
@ApiSupport(author = "xiaoymin@foxmail.com")
@RestController
@RequestMapping("/api/nxew203")
public class Api203Constroller {


    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "GET请求参数出现NULL的情况啊")
    @GetMapping("/ex")
    public Rest<LongUser> findAll(HttpServletRequest request,LongUser longUser) {
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }

    @ApiOperation(value = "忽略参数")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers"})
    @GetMapping(value = "/getUser221",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDto> getUse1rx(KDto kDto){
        Rest<KDto> r=new Rest<>();
        r.setData(kDto);
        return r;
    }

    @ApiOperation(value = "忽略参数-Object")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers"})
    @GetMapping(value = "/getUse1rxobj",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDtoObject> getUse1rxobj(KDtoObject kDtoObject){
        Rest<KDtoObject> r=new Rest<>();
        r.setData(kDtoObject);
        return r;
    }

    @ApiOperation(value = "忽略参数-Object1")
    @ApiOperationSupport(ignoreParameters = {"nodes[0].knife4jUsers","obj"})
    @GetMapping(value = "/getUse1rxobj1",consumes = "application/x-www-form-urlencoded;charset=utf-8")
    public Rest<KDtoInfo> getUse1s1rxobj(KDtoInfo kDtoObject){
        Rest<KDtoInfo> r=new Rest<>();
        r.setData(kDtoObject);
        return r;
    }

    @ApiOperation(value = "json请求url携带参数")
    @PostMapping("/urp")
    public Rest<LongUser> getParams(HttpServletRequest request,@RequestParam(value = "token")String token,@RequestBody LongUser longUser){
        Enumeration<String> params= request.getParameterNames();
        while (params.hasMoreElements()){
            String key=params.nextElement();
            String value=request.getParameter(key);
            System.out.println("key:"+key+",value:"+value);
        }
        Rest<LongUser> r=new Rest<>();
        r.setData(longUser);
        return r;
    }


    /**
     * https://gitee.com/xiaoym/knife4j/issues/I1C5OQ
     * @param request
     * @param name
     * @return
     */
    @ApiOperation(value = "多余的参数请求失败")
    @GetMapping("/getOutParams")
    public Rest<List<String>> getOutParams(HttpServletRequest request,@RequestParam(value = "name")String name){
        Enumeration<String> params= request.getParameterNames();
        List<String> paramArrs=new ArrayList<>();
        while (params.hasMoreElements()){
            String key=params.nextElement();
            String value=request.getParameter(key);
            paramArrs.add("key:"+key+",value:"+value);
        }
        Rest<List<String>> r=new Rest<>();
        r.setData(paramArrs);
        return r;
    }
}
