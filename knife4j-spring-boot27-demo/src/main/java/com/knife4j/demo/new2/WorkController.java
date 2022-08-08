/*
 * Copy right © 2022 浙江力石科技股份有限公司 All Rights Reserved.
 * Official Web Site: http://lishiots.com
 */
package com.knife4j.demo.new2;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.SysUser;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Api(tags = "work-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping("/work")
public class WorkController {

    @PostMapping("/orderList")
    public ResponseEntity<String> orderList(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


    @PostMapping("/orderList1")
    public ResponseEntity<SysUser> orderList1(SysUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


}
