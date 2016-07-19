package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AddressMemberModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AddressMemberDomain extends AddressMemberModel {
    private AreaXInfoDomain province;
    private AreaXInfoDomain city;
    private AreaXInfoDomain county;
    private HuiyuanInfoDomain huiyuanInfoDomain;

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

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }
}
