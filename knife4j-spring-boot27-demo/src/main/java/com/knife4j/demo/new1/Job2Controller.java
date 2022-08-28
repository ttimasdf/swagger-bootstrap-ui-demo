/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new1;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job-20210502")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job1",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job2Controller {

    @ApiOperation(value = "动态参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",example = "张飞",dataTypeClass = String.class),
            @ApiImplicitParam(name = "money",value = "金钱",example = "123",dataTypeClass = Long.class),
            @ApiImplicitParam(name = "age",value = "年龄",example = "22",dataTypeClass = Integer.class)

    })
    @PostMapping("/params")
    public ResponseEntity<Map<String,String>> params(@ApiIgnore @RequestParam Map<String,String> value){
        return ResponseEntity.ok(value);
    }

    @PostMapping("/orderList")
    public ResponseEntity<String> orderList(HttpServletRequest request){
        log.info("aaa");
        List<String> headerNames= CollectionUtil.newArrayList(request.getHeaderNames());
        for (String header:headerNames){
            log.info("header:{},value:{}",header, StrUtil.join(";",CollectionUtil.newArrayList(request.getHeaders(header))));
        }
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


    @PostMapping("/orderList1")
    public ResponseEntity<String> orderList1(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


}
