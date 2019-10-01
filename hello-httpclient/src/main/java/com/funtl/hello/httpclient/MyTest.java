package com.funtl.hello.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        get();

}
    public static void get(){

        //创建HttpClient客户端，打开浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();

        //创建GET请求，输入URL
        HttpGet httpGet = new HttpGet("http://localhost:8888/user/page?draw=1&start=0&length=10");
        httpGet.setHeader("Connection","keep-alive");
        httpGet.setHeader("Cookie","Idea-d796403=752356f4-c13e-47e8-a5a9-39edbe1dc85a; Idea-dd3bbdc1=cd7729c2-e491-4904-abe2-afca049af75d; JSESSIONID=22312D9C0ABF4078EC987B442D50DAB7");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(httpClient!=null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private static void post(){
        //创建HttpClient客户端，打开浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();

        //创建POST请求，输入URL
        HttpPost httpPost = new HttpPost("http://localhost:8888/user/page");
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Cookie","Idea-d796403=752356f4-c13e-47e8-a5a9-39edbe1dc85a; Idea-dd3bbdc1=cd7729c2-e491-4904-abe2-afca049af75d; JSESSIONID=6077931D7C5F3AAFE67925E7BC6E52A6");
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");

        //创建请求参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("draw","1"));
        params.add(new BasicNameValuePair("start","0"));
        params.add(new BasicNameValuePair("length","10"));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




