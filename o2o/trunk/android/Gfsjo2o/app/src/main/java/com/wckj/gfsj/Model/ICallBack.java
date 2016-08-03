package com.wckj.gfsj.Model;

import com.wckj.gfsj.Bean.Base.BaseRequest;

import okhttp3.Call;

/**
 * Created by jinlei on 2016/8/3.
 */
public interface ICallBack<T extends BaseRequest> {
    public void onError(Call call, Exception e, int id);

    public void onResponse(T response, int id);
}
