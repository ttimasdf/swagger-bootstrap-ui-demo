/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.demo.web;

import com.xiaominfo.knife4j.demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 *
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:38
 */
@Tag(name = "用户模块1")
@RestController
@RequestMapping("/user1")
public class UserOneController {

    @Operation(summary = "创建用户2",description = "根据姓名创建用户1")
    @PostMapping("/createOne2")
    public ResponseEntity<User> createOne1(@ParameterObject User user){
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "创建用户3",description = "根据姓名创建用户1")
    @PostMapping("/createOne3")
    public ResponseEntity<User> createOne2( User user){
        return ResponseEntity.ok(user);
    }


    @Operation(summary = "创建用户",description = "根据姓名创建用户")
    @GetMapping("/create")
    @ApiResponse(responseCode = "202", description = "OK",
            content = @Content(examples = @ExampleObject(value = "{\"message\": \"finished\", \"id\": \"101\" }")))
    public ResponseEntity<String> create(String name){
        return ResponseEntity.ok(name);
    }

}
