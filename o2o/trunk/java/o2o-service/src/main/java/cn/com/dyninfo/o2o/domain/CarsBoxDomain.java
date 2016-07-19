package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.CarsBoxModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class CarsBoxDomain extends CarsBoxModel{
    private GoodsDomain goodsDomain;
    private HuiyuanInfoDomain huiyuanInfoDomain;

    public GoodsDomain getGoodsDomain() {
        return goodsDomain;
    }

    public void setGoodsDomain(GoodsDomain goodsDomain) {
        this.goodsDomain = goodsDomain;
    }

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }
}
