package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ActiveModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ActiveDomain extends ActiveModel {
    private  ShangJiaInfoDomain shangJiaInfoDomain;
    private List<GoodsDomain> goodsDomainList;
    private List<ActiveGoodsDomain> activeGoodsDomainList;

    public ShangJiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangJiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }

    public List<GoodsDomain> getGoodsDomainList() {
        return goodsDomainList;
    }

    public void setGoodsDomainList(List<GoodsDomain> goodsDomainList) {
        this.goodsDomainList = goodsDomainList;
    }

    public List<ActiveGoodsDomain> getActiveGoodsDomainList() {
        return activeGoodsDomainList;
    }

    public void setActiveGoodsDomainList(List<ActiveGoodsDomain> activeGoodsDomainList) {
        this.activeGoodsDomainList = activeGoodsDomainList;
    }
}
