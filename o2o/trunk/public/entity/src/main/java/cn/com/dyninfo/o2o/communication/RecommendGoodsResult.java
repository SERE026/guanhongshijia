package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.entity.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class RecommendGoodsResult extends BaseResult {

    //新品推荐列表
    private List<Recommend> newList;

    //团购列表
    private List<Recommend> groupList;

    //促销列表
    private List<Recommend> promotionList;

    public List<Recommend> getNewList() {
        return newList;
    }

    public void setNewList(List<Recommend> newList) {
        this.newList = newList;
    }

    public List<Recommend> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Recommend> groupList) {
        this.groupList = groupList;
    }

    public List<Recommend> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Recommend> promotionList) {
        this.promotionList = promotionList;
    }
}