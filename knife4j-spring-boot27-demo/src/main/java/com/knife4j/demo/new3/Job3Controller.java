/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new3;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.ModelUser;
import com.knife4j.demo.model.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job3-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job3",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job3Controller {

    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @PostMapping("/hidden3")
    public ResponseEntity<ModelUser> i18n3(@RequestBody ModelUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


    @GetMapping("/multi")
    @ApiOperation("批量获取字典数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", allowMultiple = true, name = "codes", value = "字典编码")
    })
    public ResponseEntity<String[]> multiDict(@RequestParam String[] codes) {
        return ResponseEntity.ok(codes);
    }

    @PostMapping("/oauth")
    public ResponseEntity<Map<String,Object>> oauth(){
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("token_type","Benear");
        map.put("access_token", RandomUtil.randomString(64));
        return ResponseEntity.ok(map);
    }
}
