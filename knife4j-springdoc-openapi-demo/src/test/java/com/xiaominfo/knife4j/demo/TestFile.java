package com.xiaominfo.knife4j.demo;

import com.xiaominfo.knife4j.demo.model.FileResp;
import com.xiaominfo.knife4j.demo.model.QueryFile;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/1/10 15:45
 * @since:knife4j-springdoc-openapi-demo
 */
public class TestFile {


    public static void main(String[] args) {
        FileResp fileResp=new FileResp();
        fileResp.setName("one");
        QueryFile queryFile=new QueryFile();
        queryFile.setFileResp(fileResp);
        TestFile testFile=new TestFile();
        System.out.println("name:"+queryFile.getFileResp().getName());
        testFile.test1(queryFile);
        System.out.println("name:"+queryFile.getFileResp().getName());
    }


    public void test1(QueryFile queryFile){

        test2(queryFile.getFileResp());
    }

    public void test2(FileResp fileResp){
        fileResp.setName("test2");
    }
}
