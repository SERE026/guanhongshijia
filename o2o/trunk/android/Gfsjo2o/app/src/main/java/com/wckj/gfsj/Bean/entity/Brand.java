package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Brand extends BaseEntity {
    //商标名称
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "title='" + title + '\'' +
                '}';
    }
}
