/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/07 10:42
 * @since:knife4j-spring-boot-demo 1.0
 */
@Api(tags = "2.0.9版本-20210307")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 279)
@RestController
@RequestMapping("/api/nxew209")
public class Api209Controller {
    Logger logger= LoggerFactory.getLogger(Api209Controller.class);

    @ApiOperation(value = "注解List示例值时",notes = "详见https://gitee.com/xiaoym/knife4j/issues/I2D6D4")
    @PostMapping("/userList")
    public Rest<UserListModel> userListModelRest(@RequestBody UserListModel userListModel){
        return Rest.data(userListModel);
    }


    @ApiOperation(value = "文件上传参数Null值",notes = "https://gitee.com/xiaoym/knife4j/issues/I3AHDQ")
    @PostMapping("/upload")
    public Rest<String> upload(@RequestParam("uploadFile")MultipartFile multipartFile, @RequestParam(value = "name",required = false)String name){
        logger.info("文件：{}，name:{}",multipartFile.getOriginalFilename(),name);
        return Rest.data(RandomUtil.randomString(5)+",name:"+name);
    }
}
