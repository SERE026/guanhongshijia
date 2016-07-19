package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ActiveMemberInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ActiveMemberInfoDomain extends ActiveMemberInfoModel {
    private HuiyuanInfoDomain huiyuanInfoDomain;
    private ActiveDomain activeDomain;
    private GoodsDomain goodsDomain;

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }

    public GoodsDomain getGoodsDomain() {
        return goodsDomain;
    }

    public void setGoodsDomain(GoodsDomain goodsDomain) {
        this.goodsDomain = goodsDomain;
    }

    public ActiveDomain getActiveDomain() {
        return activeDomain;
    }

    public void setActiveDomain(ActiveDomain activeDomain) {
        this.activeDomain = activeDomain;
    }
}
