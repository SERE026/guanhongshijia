package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ActiveGoodsModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ActiveGoodsDomain extends ActiveGoodsModel {
    private GoodsDomain goodsDomain;
    private ActiveDomain activeDomain;

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
