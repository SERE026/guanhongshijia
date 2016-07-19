package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.BrandOrderModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class BrandOrderDomain extends BrandOrderModel {
    private BrandDomain brandDomain;
    private AreaInfoDomain areaInfoDomain;
    private ShangJiaInfoDomain shangJiaInfoDomain;

    public BrandDomain getBrandDomain() {
        return brandDomain;
    }

    public void setBrandDomain(BrandDomain brandDomain) {
        this.brandDomain = brandDomain;
    }

    public AreaInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }

    public ShangJiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangJiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }
}
