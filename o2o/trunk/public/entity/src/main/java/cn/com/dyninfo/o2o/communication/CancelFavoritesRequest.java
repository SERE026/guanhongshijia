package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 取消收藏夹请求
 * request URL: https://serverurl/app/favorites/cancel
 * request method: post
 */
public class CancelFavoritesRequest extends BaseRequest {

    private String goodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "CancelFavoritesRequest{" +
                "goodsId='" + goodsId + '\'' +
                '}';
    }
}
