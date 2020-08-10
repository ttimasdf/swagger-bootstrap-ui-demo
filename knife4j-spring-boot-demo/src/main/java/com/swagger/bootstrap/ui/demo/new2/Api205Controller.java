/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.grn.MapInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/***
 *
 * @since:knife4j-spring-boot-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020-8-9 10:47:39
 */
@Api(tags = "2.0.5版本-20200809")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 284)
@RestController
@RequestMapping("/api/nxew205")
public class Api205Controller {

    @ApiOperation(value = "描述支持markdown",notes = "# 访问此接口返回Hello语句<br />## 二级标题 你好Markdown`markdown`是一个不错的")
    @GetMapping("/description")
    public Rest<MapInfo> getInfo(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }
    @ApiOperation(value = "描述支持markdown",notes = "# 一、前言\n" +
            "\n" +
            "v2.0 搜索组件渲染接口\n" +
            "\n" +
            "\n" +
            "\n" +
            "# 二、请求参数\n" +
            "\n" +
            "- searchCode:搜索编码,后端定义,每个页面固定使用\n" +
            "\n" +
            "\n" +
            "\n" +
            "# 三、返回参数\n" +
            "\n" +
            "返回参数:JSON\n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "\t\"data\": {\n" +
            "\t\t\"children\": {},\n" +
            "\t\t\"id\": 0,\n" +
            "\t\t\"name\": \"\"\n" +
            "\t},\n" +
            "\t\"errCode\": 0,\n" +
            "\t\"message\": \"\",\n" +
            "\t\"success\": true\n" +
            "}\n" +
            "```\n" +
            "\n")
    @GetMapping("/description1")
    public Rest<MapInfo> getInfo1(){
        Rest<MapInfo> r=new Rest<>();
        return r;
    }

    @ApiOperation(value = "curl为空的问题")
    @PostMapping("/codes")
    public Rest<String> codes(@RequestParam(value = "code",required = false) String code){
        if (StrUtil.isNotBlank(code)){
            return Rest.data(code);
        }else{
            return Rest.data(RandomUtil.randomString(10));
        }
    }
}
