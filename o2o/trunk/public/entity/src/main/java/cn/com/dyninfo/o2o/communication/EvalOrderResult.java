package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class EvalOrderResult extends BaseResult {

    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "EvalOrderResult{" +
                "orderList=" + orderList +
                '}';
    }
}
