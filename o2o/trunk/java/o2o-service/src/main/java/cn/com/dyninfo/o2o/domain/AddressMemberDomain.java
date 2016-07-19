package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AddressMemberModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AddressMemberDomain extends AddressMemberModel {
    private AreaInfoDomain province;
    private AreaInfoDomain city;
    private AreaInfoDomain county;
    private HuiyuanInfoDomain huiyuanInfoDomain;

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

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }
}
