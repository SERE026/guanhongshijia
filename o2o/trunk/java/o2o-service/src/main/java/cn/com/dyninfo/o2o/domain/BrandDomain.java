package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.BrandModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class BrandDomain extends BrandModel {
    public ShangJiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangJiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }

    private ShangJiaInfoDomain shangJiaInfoDomain;
}
