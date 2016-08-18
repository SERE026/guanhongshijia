package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageRequest;

/**
 * 根据商品分类查询商品列表请求类
 * request URL: https://serverurl/app/goods/listByBrand
 * request method: post
 */
public class CategoryBrandListRequest extends PageRequest {



    @Override
    public String toString() {
        return "CategoryBrandListRequest{" +
                "categoryId=" +
                '}';
    }
}
