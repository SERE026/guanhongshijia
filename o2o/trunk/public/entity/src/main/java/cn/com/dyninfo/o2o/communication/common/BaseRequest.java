package cn.com.dyninfo.o2o.communication.common;

import java.io.Serializable;

/**
 * 启动请求类
 */
public class BaseRequest implements Serializable {

    //登录成功后后台返回的token，每次请求时都要赋值，为空表示未登录
    private String token;
    //设备识别码
    private String deviceId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
