package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.MerchantsApplyModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class MerchantsApplyDomain extends MerchantsApplyModel {
    private BusinessTypeDomain businessTypeDomain;
    private MerchantTypeDomain merchantTypeDomain;
    private AreaInfoDomain province;
    private AreaInfoDomain city;
    private AreaInfoDomain county;
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

    public AreaInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaInfoDomain province) {
        this.province = province;
    }

    public AreaInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaInfoDomain city) {
        this.city = city;
    }

    public AreaInfoDomain getCounty() {
        return county;
    }

    public void setCounty(AreaInfoDomain county) {
        this.county = county;
    }
}
