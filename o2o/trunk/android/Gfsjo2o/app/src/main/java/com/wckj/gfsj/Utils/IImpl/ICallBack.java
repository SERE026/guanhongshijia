package com.wckj.gfsj.Utils.IImpl;

import okhttp3.Call;

public interface ICallBack{
    void onError(Call call, Exception e);

    void onSuccess(String response);
}