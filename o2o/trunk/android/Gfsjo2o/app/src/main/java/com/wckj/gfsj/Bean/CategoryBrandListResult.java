package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Brand;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CategoryBrandListResult extends PageResult {

    private List<Brand> brandList;


    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
    @Override
    public String toString() {
        return "CategoryBrandListResult{" +
                "brandList=" + brandList +
                '}';
    }
}
