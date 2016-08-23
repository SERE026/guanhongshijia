package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;

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
