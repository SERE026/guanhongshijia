package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodsSpecValModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodsSpecValDomain extends GoodsSpecValModel {
    private GoodsSpecDomain spec;
    private GoodsDomain goods;

    public GoodsSpecDomain getSpec() {
        return spec;
    }

    public void setSpec(GoodsSpecDomain spec) {
        this.spec = spec;
    }

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
    }
}
