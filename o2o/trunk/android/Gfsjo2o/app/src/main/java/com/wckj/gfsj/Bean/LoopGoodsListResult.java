package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseResult;
import com.wckj.gfsj.Bean.entity.GoodsDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class LoopGoodsListResult extends BaseResult {

    private List<GoodsDetail> goodsDetailList;

    public List<GoodsDetail> getGoodsDetailList() {
        return goodsDetailList;
    }

    public void setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
        this.goodsDetailList = goodsDetailList;
    }

    @Override
    public String toString() {
        return "LoopGoodsListResult{" +
                "goodsDetailList=" + goodsDetailList +
                '}';
    }
}
