/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.PageVo;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.IgnoreP1;
import com.swagger.bootstrap.ui.demo.domain.resp208.RequestValidateModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.IndexTree;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModelRegex;
import com.swagger.bootstrap.ui.demo.domain.resp210.SysUser;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/07 10:42
 * @since:knife4j-spring-boot-demo 1.0
 */
@Api(tags = "2.1.0版本-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping("/api/nxew210")
public class Api210Controller {
    Logger logger= LoggerFactory.getLogger(Api210Controller.class);



    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",required = true),
            @ApiImplicitParam(name = "title",value = "标题"),
            @ApiImplicitParam(name = "age",value = "年龄")
    })
    @PostMapping("/reuqireParams")
    public Rest<String> requireParams(@RequestParam("name") String name,
                                      @RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "age",required = false) Integer age){
        return Rest.data("name:"+name+",title:"+title+",age:"+age);
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/getUsers")
    public Rest<List<SysUser>> get(){
        return Rest.data(CollectionUtil.newArrayList(new SysUser()));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",required = true),
            @ApiImplicitParam(name = "title",value = "标题"),
            @ApiImplicitParam(name = "age",value = "年龄")
    })
    @GetMapping("/reuqireParamsGet")
    public Rest<String> reuqireParamsGet(@RequestParam("name") String name,
                                      @RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "age",required = false) Integer age){
        return Rest.data("name:"+name+",title:"+title+",age:"+age);
    }
}
