/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/08/10 20:28
 */
public class Dxx {

    public static void main(String[] args) {
        try{
            job1();
            job2();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    static void job1(){
        System.out.println("job1");
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8999/api/new187/responseMulti1");
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        httpclient.start();
        httpclient.execute(httpPost, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse httpResponse) {
                System.out.println("completed............");
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
                System.out.println(httpResponse.getStatusLine());
                try{
                    String content = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                    System.out.println(" response content is : " + content);
                }catch (Exception e){

                }
            }

            @Override
            public void failed(Exception e) {
                System.out.println("failed..."+e.getMessage());
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
            }

            @Override
            public void cancelled() {
                System.out.println("cancelled...");
                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
            }
        });
    }

    static void job2() throws Exception{
        System.out.println("job2");
        String path ="http://127.0.0.1:8999/api/new187/responseMulti";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建一个 GET 请求
        HttpPost httpPost = new HttpPost(path);
        //装填参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("name", "TestName"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        // 执行请求
        CloseableHttpResponse response =httpClient.execute(httpPost);
        //取响应的结果
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(content);
        //关闭httpclient
        response.close();
        httpClient.close();
    }
}
