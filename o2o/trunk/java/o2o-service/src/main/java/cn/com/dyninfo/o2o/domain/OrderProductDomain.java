package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.OrderProductModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class OrderProductDomain extends OrderProductModel {
    private OrderDomain order;
    private ProductDomain product;
    private ActiveDomain act;
    private ActiveMemberInfoDomain ami;

    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
    }

    public ActiveDomain getAct() {
        return act;
    }

    public void setAct(ActiveDomain act) {
        this.act = act;
    }

    public ActiveMemberInfoDomain getAmi() {
        return ami;
    }

    public void setAmi(ActiveMemberInfoDomain ami) {
        this.ami = ami;
    }
}
