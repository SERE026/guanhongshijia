package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;

/**
 * Created by Administrator on 2016/7/25.
 */
public class LoginResult extends BaseResult {

    //登录成功后返回
    private String token;

    //用户名
    private String loginName;

    //真实姓名
    private String realName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
