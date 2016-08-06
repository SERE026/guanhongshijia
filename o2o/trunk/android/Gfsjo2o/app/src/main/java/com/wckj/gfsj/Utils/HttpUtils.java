package com.wckj.gfsj.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.Base.BaseRequest;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/29.
 */
public class HttpUtils {
    private HttpUtils(){}
    private static HttpUtils instance;
    private  static OkHttpClient client ;
     public static HttpUtils getInstance(){
         if(instance==null){
             instance=new HttpUtils();
         }
         if(client==null){
             client = new OkHttpClient();
         }
         return instance;
     }

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");



    /**
     * 同步POST请求
     * @param appRequest
     * @param url
     * @param clazz 返回类型，如登录使用LoginResult.class
     * @param <T>
     * @return
     * @throws IOException
     */
    public  <T> T syncPost(BaseRequest appRequest, String url, Class<T> clazz) throws IOException {
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
    public  void asyncPost(BaseRequest appRequest, final String url, final ICallBack callBack) {
        if(AppApplication.loginResult!=null){
            if(AppApplication.loginResult.getToken()!=null){
                appRequest.setToken(AppApplication.loginResult.getToken());
            }
            appRequest.setDeviceId(AppApplication.loginResult.getDeviceId());
        }

        String jsonStr = JSON.toJSONString(appRequest, SerializerFeature.WriteMapNullValue);
        LogTools.println(null,"请求参数=="+jsonStr);
        OkHttpUtils
                .postString()
                .url(url)
                .content(jsonStr)
                .mediaType(JSON_TYPE)
                .build()
                .execute(new com.zhy.http.okhttp.callback.Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        return response.body().string();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.onError(call,e);
                    }
                    @Override
                    public void onResponse(Object response, int id) {
                        LogTools.println(null,"url===="+url);
                        LogTools.println(null,"response===="+response);
                        callBack.onSuccess((String) response);
    }
});
    }

}
