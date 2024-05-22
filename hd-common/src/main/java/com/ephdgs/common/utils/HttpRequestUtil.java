package com.ephdgs.common.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Date: 2024/2/8
 * @Author: Hill
 */
public class HttpRequestUtil {

    /**
     * HTTP接口-GET方式，请求参数形式为params形式
     *
     * @param url
     * @return String
     */
    public static String sendGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response;
        String result;
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            throw new IOException(e);
        }
        return result;
    }

    /**
     * 表单形式post请求
     *
     * @param url 请求地址
     * @param map post请求参数
     * @return String 请求结果
     */
    public static String doPostWithForm(Map<String, String> map, String url) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();
        //构建一个formBody builder
        FormBody.Builder builder = new FormBody.Builder();
        //循环form表单，将表单内容添加到form builder中
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            builder.add(key, value);
        }
        //构建formBody，将其传入Request请求中
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        //返回请求结果
        try (Response response = call.execute()) {
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * HTTP接口-POST方式，请求参数形式为body-json形式
     *
     * @param url 路径
     * @param jsonString 参数
     * @return String
     */
    public static String sendPostWithJson(String url, String jsonString) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString);
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = client.newCall(request);
        //返回请求结果
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * HTTP接口-POST方式，请求参数形式为params形式
     *
     * @param url 路径
     * @param param 参数
     * @return String
     */
    public static String sendPost(String url, String param) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        FormBody body = new FormBody.Builder().build();
        String dataUrl = url + "?userName=" + param;
        Request request = new Request.Builder()
                .url(dataUrl)
                .post(body)
                .build();
        Response response;
        String result;
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            throw new IOException(e);
        }
        return result;
    }

}
