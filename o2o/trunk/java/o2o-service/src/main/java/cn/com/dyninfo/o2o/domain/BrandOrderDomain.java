package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.BrandOrderModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class BrandOrderDomain extends BrandOrderModel {
    private BrandDomain brandDomain;
    private AreaXInfoDomain areaInfoDomain;
    private ShangjiaInfoDomain shangJiaInfoDomain;

    public BrandDomain getBrandDomain() {
        return brandDomain;
    }

    public void setBrandDomain(BrandDomain brandDomain) {
        this.brandDomain = brandDomain;
    }

    public AreaXInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaXInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }

    public ShangjiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangjiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }
}
