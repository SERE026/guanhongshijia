package cn.com.dyninfo.o2o.communication.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/25.
 */
public class BaseResult implements Serializable {

    //返回码，0-成功；1-无权限（需要登录）；待完善
    private int resultCode;

    //返回的错误信息
    private String message;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
