package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * Created by Administrator on 2016/7/29.
 */
public class AgencyFeeItem extends BaseEntity {

    //订单完成日期
    private String date="";
    //订单号
    private String orderNo="";
    //商品总价（去除优惠券抵扣价格）
    private double price;
    //佣金比率
    private String percent="";
    //佣金金额
    private double amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AgencyFeeItem{" +
                "date='" + date + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", percent='" + percent + '\'' +
                ", amount=" + amount +
                '}';
    }
}
