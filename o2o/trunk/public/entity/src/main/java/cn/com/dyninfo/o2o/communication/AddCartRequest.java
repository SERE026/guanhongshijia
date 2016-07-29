package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.GoodsSpecValue;

import java.util.List;

/**
 * 添加到购物车请求类
 * request URL: https://serverurl/app/addCart
 * request method: post
 */
public class AddCartRequest extends BaseRequest {

    private String goodsId;

    private int count;

    private List<GoodsSpecValue> goodsSpecValueList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GoodsSpecValue> getGoodsSpecValueList() {
        return goodsSpecValueList;
    }

    public void setGoodsSpecValueList(List<GoodsSpecValue> goodsSpecValueList) {
        this.goodsSpecValueList = goodsSpecValueList;
    }
}
