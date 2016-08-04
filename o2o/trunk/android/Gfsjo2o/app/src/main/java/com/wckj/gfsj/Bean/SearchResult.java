package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.GoodsSummary;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class SearchResult extends PageResult {

    private List<GoodsSummary> goodsSummaryList;

    public List<GoodsSummary> getGoodsSummaryList() {
        return goodsSummaryList;
    }

    public void setGoodsSummaryList(List<GoodsSummary> goodsSummaryList) {
        this.goodsSummaryList = goodsSummaryList;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "goodsSummaryList=" + goodsSummaryList +
                '}';
    }
}
