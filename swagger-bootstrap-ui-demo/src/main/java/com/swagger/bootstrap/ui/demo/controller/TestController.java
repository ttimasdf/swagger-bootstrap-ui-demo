package com.swagger.bootstrap.ui.demo.controller;

import com.swagger.bootstrap.ui.demo.common.RestMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/04/20 14:01
 */
@Api("测试接口")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @ApiOperation(value = "测试接口1",notes = "测试说明1")
    @GetMapping(value = "/xdf_{code}")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage urlpath(@PathVariable(value = "code") String code, Boolean st){
        return new RestMessage(code);
    }

    @ApiOperation(value = "测试接口2",notes = "测试说明2")
    @PostMapping(value = "/gxx_code")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage gxx_code(String code, Boolean st){
        return new RestMessage(code);
    }


    @ApiOperation(value = "puttest",notes = "puttest测试说明2")
    @PutMapping(value = "/puttest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string")
    public RestMessage puttest(String code){
        return new RestMessage(code);
    }

    @ApiOperation(value = "deletetest",notes = "deletetest测试说明2")
    @DeleteMapping(value = "/deletetest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string")
    public RestMessage deletetest(@RequestParam(value = "code") String code){
        return new RestMessage(code);
    }
}
