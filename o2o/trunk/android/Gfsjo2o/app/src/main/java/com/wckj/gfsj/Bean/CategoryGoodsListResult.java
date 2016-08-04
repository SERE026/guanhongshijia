package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Brand;
import com.wckj.gfsj.Bean.entity.GoodsSummary;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CategoryGoodsListResult extends PageResult {

    private List<Brand> brandList;

    private List<GoodsSummary> goodsSummaryList;

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<GoodsSummary> getGoodsSummaryList() {
        return goodsSummaryList;
    }

    public void setGoodsSummaryList(List<GoodsSummary> goodsSummaryList) {
        this.goodsSummaryList = goodsSummaryList;
    }

    @Override
    public String toString() {
        return "CategoryGoodsListResult{" +
                "brandList=" + brandList +
                ", goodsSummaryList=" + goodsSummaryList +
                '}';
    }
}
