package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.GoodsSummary;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class FavoritesListResult extends PageResult {

    private List<GoodsSummary> goodsSummaryList;

    public List<GoodsSummary> getGoodsSummaryList() {
        return goodsSummaryList;
    }

    public void setGoodsSummaryList(List<GoodsSummary> goodsSummaryList) {
        this.goodsSummaryList = goodsSummaryList;
    }

    @Override
    public String toString() {
        return "FavoritesListResult{" +
                "goodsSummaryList=" + goodsSummaryList +
                '}';
    }
}
