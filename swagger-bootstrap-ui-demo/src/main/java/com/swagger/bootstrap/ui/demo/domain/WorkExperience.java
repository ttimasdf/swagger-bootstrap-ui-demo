/*
 * Copyright (C) 2018 Zhejiang lishiots Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.lishiots.com.
 * Developer Web Site: http://open.lishiots.com.
 */

package com.swagger.bootstrap.ui.demo.domain;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/04/28 10:24
 */
public class WorkExperience {
    private String company;
    private String role;
    private String start;
    private String end;

    public WorkExperience(String company, String role, String start, String end) {
        this.company = company;
        this.role = role;
        this.start = start;
        this.end = end;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
