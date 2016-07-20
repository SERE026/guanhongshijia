package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.SendOrderModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class SendOrderDomain extends SendOrderModel {
    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    private OrderDomain order;
}
