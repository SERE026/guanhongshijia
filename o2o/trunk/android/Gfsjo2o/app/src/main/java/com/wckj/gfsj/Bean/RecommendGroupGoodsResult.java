package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class RecommendGroupGoodsResult extends PageResult {

    //团购列表
    private List<Recommend> groupList;
    private  String image="";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Recommend> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Recommend> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "RecommendGoodsGroupResult{" +
                "groupList=" + groupList +
                '}';
    }
}
