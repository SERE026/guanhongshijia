package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CartItem extends BaseEntity {
    //商品信息
    private GoodsDetail goodsDetail;
    //数量
    private int count;
    //商品参数值，内部已关联了对应的商品参数
    private GoodsSpecValue specValue;

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
