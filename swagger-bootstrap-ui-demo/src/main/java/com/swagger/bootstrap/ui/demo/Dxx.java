/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/10 20:28
 */
public class Dxx {

    public static void main(String[] args) throws FileNotFoundException {
        JsonParser jsonParser=new JsonParser();
        File file=new File("D:\\Users\\xiaoymin\\code\\oschina\\swagger-bootstrap-ui-demo\\swagger-bootstrap-ui-demo\\src\\main\\resources\\d1.json");
        System.out.println(file.getPath());
        JsonElement jsonElement=jsonParser.parse(new FileReader(file));
        System.out.println(file.length());
        System.out.println(jsonElement.toString());
    }
}
