package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.TryUseApplyModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class TryuseApplyDomain extends TryUseApplyModel {
    private HuiyuanInfoDomain huiyuan;
    private GoodsDomain goods;
    private AreaInfoDomain province;
    private AreaInfoDomain city;

    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
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

    private AreaInfoDomain county;
}
