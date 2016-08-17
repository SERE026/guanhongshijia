package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageRequest;

/**
 * 根据商品分类查询商品列表请求类
 * request URL: https://serverurl/app/goods/listByBrand
 * request method: post
 */
public class CategoryBrandListRequest extends PageRequest {

    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CategoryBrandListRequest{" +
                "categoryId=" + categoryId +
                '}';
    }
}
