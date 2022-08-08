/*
 * Copy right © 2022 浙江力石科技股份有限公司 All Rights Reserved.
 * Official Web Site: http://lishiots.com
 */
package com.knife4j.demo.new2;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job",produces = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

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
