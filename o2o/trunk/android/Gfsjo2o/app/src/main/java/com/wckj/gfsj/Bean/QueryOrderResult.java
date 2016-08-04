package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QueryOrderResult extends PageResult {

    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "QueryOrderResult{" +
                "orderList=" + orderList +
                '}';
    }
}
