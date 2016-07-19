package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.TryUseApplyModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class TryuseApplyDomain extends TryUseApplyModel {
    private HuiyuanInfoDomain huiyuan;
    private GoodsDomain goods;
    private AreaXInfoDomain province;
    private AreaXInfoDomain city;

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

    private AreaXInfoDomain county;
}
