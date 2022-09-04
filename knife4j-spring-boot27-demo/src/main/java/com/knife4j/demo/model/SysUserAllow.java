/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */

package com.knife4j.demo.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;


/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/5/1 13:32
 * @since:knife4j-spring-boot-demo 1.0
 */
public class SysUserAllow {
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "状态",allowableValues = "0,1,2")
    private Integer status;

    @ApiModelProperty(value = "部门id")
    private Long depId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }
}
