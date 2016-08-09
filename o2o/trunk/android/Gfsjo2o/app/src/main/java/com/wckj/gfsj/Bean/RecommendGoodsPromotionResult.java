package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class RecommendGoodsPromotionResult extends PageResult {

    //促销列表
    private List<Recommend> promotionList;


    public List<Recommend> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Recommend> promotionList) {
        this.promotionList = promotionList;
    }

    @Override
    public String toString() {
        return "RecommendGoodsResult{" +
                "promotionList=" + promotionList +
                '}';
    }
}
