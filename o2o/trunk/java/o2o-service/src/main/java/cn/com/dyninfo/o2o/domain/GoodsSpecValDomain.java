package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodsSpecValModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodsSpecValDomain extends GoodsSpecValModel {
    private GoodSpecDomain spec;
    private GoodsDomain goods;

    public GoodSpecDomain getSpec() {
        return spec;
    }

    public void setSpec(GoodSpecDomain spec) {
        this.spec = spec;
    }

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
    }
}
