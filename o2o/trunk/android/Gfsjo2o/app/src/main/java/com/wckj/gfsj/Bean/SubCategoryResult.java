package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.CategoryTwo;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class SubCategoryResult extends PageResult {

    private List<CategoryTwo> categoryList;


    public List<CategoryTwo> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryTwo> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "SubCategoryResult{" +
                "categoryList=" + categoryList +
                '}';
    }
}
