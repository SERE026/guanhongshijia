package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AttachInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AttachInfoDomain extends AttachInfoModel {
    public UserInfoDomain getUserInfoDomain() {
        return userInfoDomain;
    }

    public void setUserInfoDomain(UserInfoDomain userInfoDomain) {
        this.userInfoDomain = userInfoDomain;
    }

    private UserInfoDomain userInfoDomain;
}
