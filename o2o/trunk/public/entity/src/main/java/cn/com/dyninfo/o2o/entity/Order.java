package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Order extends BaseEntity {

    //订单日期
    private String date;
    //状态
    private int state;
    //收货人姓名
    private String receiveName;
    //订单金额
    private Double orderPrice;
    //支付方式：1-支付宝；2-银联；10-线下；11-支付宝+线下；12-银联+线下
    private int payType;
    //订单商品列表
    private List<CartItem> cartItemList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", state=" + state +
                ", receiveName='" + receiveName + '\'' +
                ", orderPrice=" + orderPrice +
                ", payType=" + payType +
                ", cartItemList=" + cartItemList +
                '}';
    }
}
