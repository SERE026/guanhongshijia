package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Recommend;

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
