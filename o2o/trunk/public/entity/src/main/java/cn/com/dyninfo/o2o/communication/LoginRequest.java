package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 登录请求类
 * request URL: https://serverurl/app/user/login
 * request method: post
 */
public class LoginRequest extends BaseRequest {

    private String loginName;

    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
