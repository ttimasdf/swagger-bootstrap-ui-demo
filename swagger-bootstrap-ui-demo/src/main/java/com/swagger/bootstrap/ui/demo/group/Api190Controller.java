/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.group;

import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp190.BatchModifyForGoodsReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/***
 * 1.8.9fixed bug修改
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019-1-7 16:18:56
 */
@Api(tags = "1.9.0版本-20190114",position = 295)
@RestController
@RequestMapping(value = "/api/new190/")
public class Api190Controller {

    Logger logger= LoggerFactory.getLogger(Api190Controller.class);


    @ApiOperation(value = "下载测试-无参数版",position = 1)
    @GetMapping(value = "/downloadFile1",produces = "application/octet-stream")
    public void postRequest2(HttpServletRequest request, HttpServletResponse response){
        download("八一菜刀",response);
    }

    @ApiOperation(value = "下载测试-有参数版",position = 2)
    @GetMapping(value = "/downloadFileAndParam",produces = "application/octet-stream")
    public void postRequest2AndParam(@RequestParam(value = "name") String name, HttpServletRequest request, HttpServletResponse response){
        download(name,response);
    }
    @ApiOperation(value = "下载测试-有参数+请求头版",position = 3)
    @GetMapping(value = "/downloadFileAndParam2",produces = "application/octet-stream")
    public void postRequest3AndParam(@RequestHeader(value = "uud") String uud,@RequestParam(value = "name") String name, HttpServletRequest request, HttpServletResponse response){
        logger.info("header:{}",uud);
        download(name,response);
    }

    @ApiOperation(value = "枚举请求类型")
    @PostMapping("/enumRequest")
    public Rest<BatchModifyForGoodsReq> emRequest(BatchModifyForGoodsReq batchModifyForGoodsReq){
        Rest<BatchModifyForGoodsReq> r=new Rest<>();
        r.setData(batchModifyForGoodsReq);
        return r;
    }

    private void download(String name,HttpServletResponse response){
        String fileName=new Random().nextInt(1000)+".txt";
        try {
            response.setContentType("text/plain;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            ByteArrayOutputStream by=new ByteArrayOutputStream();
            String content="This test Download File Api,哈哈哈,我是中文,我是无敌的,我的名字是："+name;
            by.write(content.getBytes());
            by.writeTo(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
