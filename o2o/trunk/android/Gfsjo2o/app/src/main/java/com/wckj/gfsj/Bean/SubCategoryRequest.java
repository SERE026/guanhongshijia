package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageRequest;

/**
 * 二级类别列表请求类
 * request URL: https://serverurl/app/category/sub
 * request method: post
 */
public class SubCategoryRequest extends PageRequest {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SubCategoryRequest{" +
                "id=" + id +
                '}';
    }
}
