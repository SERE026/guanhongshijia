package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodsDeliveryModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodsDeliveryDomain extends GoodsDeliveryModel {
    private GoodsDomain goods;
    private List<DlytypeDomain> dlyList;

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
    }

    public List<DlytypeDomain> getDlyList() {
        return dlyList;
    }

    public void setDlyList(List<DlytypeDomain> dlyList) {
        this.dlyList = dlyList;
    }
}
