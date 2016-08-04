package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;

/**
 * 添加到收藏夹请求类
 * request URL: https://serverurl/app/favorites/add
 * request method: post
 */
public class AddFavoritesRequest extends BaseRequest {

    private String goodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "AddFavoritesRequest{" +
                "goodsId='" + goodsId + '\'' +
                '}';
    }
}
