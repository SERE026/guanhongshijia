package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainCategoryResult extends PageResult {

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "MainCategoryResult{" +
                "categoryList=" + categoryList +
                '}';
    }
}
