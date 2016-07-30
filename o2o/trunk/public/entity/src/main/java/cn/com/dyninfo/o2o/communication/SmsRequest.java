package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 发送短信请求类
 * request URL: https://serverurl/app/sys/sms
 * request method: post
 */
public class SmsRequest extends BaseRequest {

    //接收短信的手机号码
    private String mobileNo;

    //请求类型，1-找回登录密码；2-找回锁定密码
    private int type;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
