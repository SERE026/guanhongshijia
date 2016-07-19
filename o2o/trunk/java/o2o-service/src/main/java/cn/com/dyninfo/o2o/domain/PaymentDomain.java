package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PaymentModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PaymentDomain extends PaymentModel {
    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    private OrderDomain order;
}
