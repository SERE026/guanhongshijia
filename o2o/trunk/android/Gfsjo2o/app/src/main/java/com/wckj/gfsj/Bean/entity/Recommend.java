package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Recommend extends BaseEntity {

    private String imageUrl;

    private  String shortDesc;

    private  String goodsStory;

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
    public String getShortDesc() { return shortDesc; }

    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    public String getGoodsStory() { return goodsStory; }

    public void setGoodsStory(String goodsStory) { this.goodsStory = goodsStory; }

    @Override
    public String toString() {
        return "Recommend{" +
                "imageUrl='" + imageUrl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", goodsStory='" + goodsStory + '\'' +
                ", goodsSummaryList=" + goodsSummaryList +
                '}';
    }
}
