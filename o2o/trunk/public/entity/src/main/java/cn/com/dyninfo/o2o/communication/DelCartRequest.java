package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.GoodsSpecValue;

import java.util.List;

/**
 * 添加到购物车请求类
 * request URL: https://serverurl/app/cart/del
 * request method: post
 */
public class DelCartRequest extends BaseRequest {

    private String goodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "AddCartRequest{" +
                "goodsId='" + goodsId + '\'' +
                '}';
    }
}
