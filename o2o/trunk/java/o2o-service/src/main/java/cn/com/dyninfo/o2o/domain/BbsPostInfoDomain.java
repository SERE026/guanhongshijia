package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.BbsPostInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class BbsPostInfoDomain extends BbsPostInfoModel {
    private BbsPostInfoDomain parent;
    private BbsUserInfoDomain hname;
    private BbsUserInfoDomain user;

    public BbsPostInfoDomain getParent() {
        return parent;
    }

    public void setParent(BbsPostInfoDomain parent) {
        this.parent = parent;
    }

    public BbsUserInfoDomain getHname() {
        return hname;
    }

    public void setHname(BbsUserInfoDomain hname) {
        this.hname = hname;
    }

    public BbsUserInfoDomain getUser() {
        return user;
    }

    public void setUser(BbsUserInfoDomain user) {
        this.user = user;
    }
}
