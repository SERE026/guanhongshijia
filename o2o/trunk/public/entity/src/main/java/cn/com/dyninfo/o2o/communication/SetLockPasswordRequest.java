package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 设置锁定密码请求类
 * request URL: https://serverurl/app/user/lockPassword
 * request method: post
 */
public class SetLockPasswordRequest extends BaseRequest {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SetLockPasswordRequest{" +
                "password='" + password + '\'' +
                '}';
    }
}
