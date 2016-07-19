package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ReturneOrderModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ReturnedorderDomain extends ReturneOrderModel {
    private OrderDomain order;

    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }
}
