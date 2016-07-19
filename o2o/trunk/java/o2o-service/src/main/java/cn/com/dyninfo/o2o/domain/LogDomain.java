package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.LogModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class LogDomain extends LogModel {
    public UserInfoDomain getUser() {
        return user;
    }

    public void setUser(UserInfoDomain user) {
        this.user = user;
    }

    private UserInfoDomain user;
}
