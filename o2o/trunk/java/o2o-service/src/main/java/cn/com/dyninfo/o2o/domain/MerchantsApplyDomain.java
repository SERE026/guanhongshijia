package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.MerchantsApplyModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class MerchantsApplyDomain extends MerchantsApplyModel {
    private BusinessTypeDomain businessTypeDomain;
    private MerchantTypeDomain merchantTypeDomain;
    private AreaXInfoDomain province;
    private AreaXInfoDomain city;
    private AreaXInfoDomain county;
    public MerchantTypeDomain getMerchantTypeDomain() {
        return merchantTypeDomain;
    }

    public void setMerchantTypeDomain(MerchantTypeDomain merchantTypeDomain) {
        this.merchantTypeDomain = merchantTypeDomain;
    }

    public BusinessTypeDomain getBusinessTypeDomain() {
        return businessTypeDomain;
    }

    public void setBusinessTypeDomain(BusinessTypeDomain businessTypeDomain) {
        this.businessTypeDomain = businessTypeDomain;
    }

    public AreaXInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaXInfoDomain province) {
        this.province = province;
    }

    public AreaXInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaXInfoDomain city) {
        this.city = city;
    }

    public AreaXInfoDomain getCounty() {
        return county;
    }

    public void setCounty(AreaXInfoDomain county) {
        this.county = county;
    }
}
