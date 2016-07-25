package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 设置锁定密码请求类
 * request URL: https://serverurl/app/lockPassword
 * request method: post
 */
public class LockPasswordRequest extends BaseRequest {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
