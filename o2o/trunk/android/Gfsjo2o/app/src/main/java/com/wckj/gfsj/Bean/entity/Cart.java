package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Cart extends BaseEntity {

    private List<CartItem> itemList;

    public List<CartItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<CartItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemList=" + itemList +
                '}';
    }
}
