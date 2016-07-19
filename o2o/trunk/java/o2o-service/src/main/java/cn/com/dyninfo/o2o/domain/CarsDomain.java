package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.CarsModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class CarsDomain extends CarsModel {
    private HuiyuanInfoDomain huiyuanInfoDomain;

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }
}
