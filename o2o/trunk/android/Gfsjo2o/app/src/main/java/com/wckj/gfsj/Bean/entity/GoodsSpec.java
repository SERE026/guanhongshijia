package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsSpec extends BaseEntity {

    private String name="";

    private List<GoodsSpecValue> specValueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecValue> getSpecValueList() {
        return specValueList;
    }

    public void setSpecValueList(List<GoodsSpecValue> specValueList) {
        this.specValueList = specValueList;
    }

    @Override
    public String toString() {
        return "GoodsSpec{" +
                "name='" + name + '\'' +
                ", specValueList=" + specValueList +
                '}';
    }
}
