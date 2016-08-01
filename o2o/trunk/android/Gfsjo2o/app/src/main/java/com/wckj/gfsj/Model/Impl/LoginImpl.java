package com.wckj.gfsj.Model.Impl;

import com.wckj.gfsj.Model.ILogin;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jinlei on 2016/8/1.
 */
public class LoginImpl implements ILogin{
    @Override
    public void login(String name, String password) {
        OkHttpUtils
                .post()
                .url("")
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {

                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Object response, int id) {

                    }
                });
    }
}
