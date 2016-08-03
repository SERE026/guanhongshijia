package com.wckj.gfsj.Model;

import com.wckj.gfsj.Utils.LogTools;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jinlei on 2016/8/3.
 */
public class BaseRequestUtils {


    private BaseRequestUtils(){

    }

    private static BaseRequestUtils instance;
    public  static BaseRequestUtils getInstance(){
        if(instance==null){
            instance=new BaseRequestUtils();
        }
        return  instance;
    }

    /**
     * 登录
     * @param name
     * @param password
     */
    public void login(String name, String password) {
        OkHttpUtils
                .post()
                .url("https://serverurl/app/user/login")
                .addParams("loginName", "lxfeng")
                .addParams("password", "123123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        LogTools.println(null,response+"::"+id);
                        return response;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogTools.println(null,e+":onError:"+id);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        LogTools.println(null,response+":onResponse:"+id);
                    }
                });
    }
}
