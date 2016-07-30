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

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginName("userName1");
        loginRequest.setPassword("password1");
        loginRequest.setDeviceId("deviceId1");
        try {
            HttpUtils.syncPost(loginRequest, LOGIN_URL, LoginResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpUtils.asyncPost(loginRequest, LOGIN_URL, new AsyncHandler() {
            @Override
            public void handle(String responseBody) {
                LoginResult loginResult = JSON.parseObject(responseBody, LoginResult.class);
                System.out.println(loginResult.getResultCode());
            }
        });
    }

    interface AsyncHandler {
        void handle(String responseBody);
    }
}
