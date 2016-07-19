package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodsDeliveryModel implements Serializable {
    private Integer id;

    private String delivery;

    private String deliveryFlag;

    private Double deliveryMoney;

    private Integer tGoods;

    private Integer tProduct;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery == null ? null : delivery.trim();
    }

    public String getDeliveryFlag() {
        return deliveryFlag;
    }

    public void setDeliveryFlag(String deliveryFlag) {
        this.deliveryFlag = deliveryFlag == null ? null : deliveryFlag.trim();
    }

    public Double getDeliveryMoney() {
        return deliveryMoney;
    }

    public void setDeliveryMoney(Double deliveryMoney) {
        this.deliveryMoney = deliveryMoney;
    }

    public Integer gettGoods() {
        return tGoods;
    }

    public void settGoods(Integer tGoods) {
        this.tGoods = tGoods;
    }

    public Integer gettProduct() {
        return tProduct;
    }

    public void settProduct(Integer tProduct) {
        this.tProduct = tProduct;
    }
}