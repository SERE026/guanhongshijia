package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CartItem extends BaseEntity {

    private String id;

    private int count;

    private GoodsSpecValue specValue;

    private GoodsDetail goodsDetail;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GoodsSpecValue getSpecValue() {
        return specValue;
    }

    public void setSpecValue(GoodsSpecValue specValue) {
        this.specValue = specValue;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
}
