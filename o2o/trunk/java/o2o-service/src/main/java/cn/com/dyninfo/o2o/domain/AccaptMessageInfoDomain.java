package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AccaptMessageModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AccaptMessageInfoDomain extends AccaptMessageModel{
    private UserMessageInfoDomain userMessageInfoDomain;

    public UserMessageInfoDomain getUserMessageInfoDomain() {
        return userMessageInfoDomain;
    }

    public void setUserMessageInfoDomain(UserMessageInfoDomain userMessageInfoDomain) {
        this.userMessageInfoDomain = userMessageInfoDomain;
    }
}
