package com.xiaominfo.knife4j.demo.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/15 12:35
 * @since:knife4j-springdoc-openapi-demo
 */
@Data
@ToString
public class MyBodyTest {

    private FileResp fileResp;

    private FileRequestVo requestVo;
}
