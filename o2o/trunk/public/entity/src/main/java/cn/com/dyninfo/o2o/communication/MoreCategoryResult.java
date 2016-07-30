package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MoreCategoryResult extends PageResult {

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "MoreCategoryResult{" +
                "categoryList=" + categoryList +
                '}';
    }
}
