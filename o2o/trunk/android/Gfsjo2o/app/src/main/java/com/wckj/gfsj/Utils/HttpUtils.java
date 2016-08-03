package com.wckj.gfsj.Utils;

import cn.com.dyninfo.o2o.communication.LoginRequest;
import cn.com.dyninfo.o2o.communication.LoginResult;
import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/29.
 */
public class HttpUtils {

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    public static final String SERVER_URL = "http://www.guanhongshijia.com/app";

    public static final String LOGIN_URL = SERVER_URL + "/user/login";

    private static OkHttpClient client = new OkHttpClient();

    /**
     * 同步POST请求
     * @param appRequest
     * @param url
     * @param clazz 返回类型，如登录使用LoginResult.class
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T syncPost(BaseRequest appRequest, String url, Class<T> clazz) throws IOException {
        String jsonStr = JSON.toJSONString(appRequest);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return JSON.parseObject(response.body().string(), clazz);
        } else {
            throw new IOException("Network error: " + response);
        }
    }

    /**
     * 异步POST请求，实际使用需要根据情况传入Handler用于回调
     * @param appRequest
     * @param url
     */
    public static void asyncPost(BaseRequest appRequest, String url, final AsyncHandler handler) {
        String jsonStr = JSON.toJSONString(appRequest);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.handle(response.body().string());
            }
       });
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginName("lxfeng");
        loginRequest.setPassword("123123");
        loginRequest.setDeviceId("deviceId1");
        //模拟登录-同步请求
        try {
            LoginResult result = HttpUtils.syncPost(loginRequest, LOGIN_URL, LoginResult.class);
            System.out.println(result.getResultCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //模拟登录-异步请求
        HttpUtils.asyncPost(loginRequest, LOGIN_URL, new AsyncHandler() {
            @Override
            public void handle(String responseBody) {
                LoginResult loginResult = JSON.parseObject(responseBody, LoginResult.class);
                System.out.println(loginResult.getResultCode());
            }
        });
    }

    /**
     * 实际使用需要定义为一个公共接口
     */
    interface AsyncHandler {
        void handle(String responseBody);
    }
}
