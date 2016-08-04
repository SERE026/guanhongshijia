package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Recommend extends BaseEntity {

    private String imageUrl;

    private List<GoodsSummary> goodsSummaryList;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<GoodsSummary> getGoodsSummaryList() {
        return goodsSummaryList;
    }

    public void setGoodsSummaryList(List<GoodsSummary> goodsSummaryList) {
        this.goodsSummaryList = goodsSummaryList;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "imageUrl='" + imageUrl + '\'' +
                ", goodsSummaryList=" + goodsSummaryList +
                '}';
    }
}
