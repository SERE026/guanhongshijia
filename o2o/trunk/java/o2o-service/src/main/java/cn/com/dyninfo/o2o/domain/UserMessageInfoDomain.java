package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.MessageInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class UserMessageInfoDomain  extends MessageInfoModel {
    private UserInfoDomain user;
    private List<AccaptMessageInfoDomain> accaptList;

    public UserInfoDomain getUser() {
        return user;
    }

    public void setUser(UserInfoDomain user) {
        this.user = user;
    }

    public List<AccaptMessageInfoDomain> getAccaptList() {
        return accaptList;
    }

    public void setAccaptList(List<AccaptMessageInfoDomain> accaptList) {
        this.accaptList = accaptList;
    }
}
