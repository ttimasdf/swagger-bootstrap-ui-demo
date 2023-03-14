package com.xiaominfo.knife4j.demo.web;

import cn.hutool.core.util.RandomUtil;
import com.xiaominfo.knife4j.demo.config.TestBody;
import com.xiaominfo.knife4j.demo.model.FileRequestVo;
import com.xiaominfo.knife4j.demo.model.FileResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/14 15:21
 * @since:knife4j-springdoc-openapi-demo
 */
@Tag(name = "测试模块")
@RestController
@RequestMapping("/test")
public class Test1Controller {

    @Operation(description = "测试一下")
    @PostMapping(value = "/module/upload",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fileModule(@TestBody FileRequestVo fileRequestVo,@TestBody FileResp fileResp, HttpServletResponse response){
        return ResponseEntity.ok(RandomUtil.randomString(23));
    }
}
