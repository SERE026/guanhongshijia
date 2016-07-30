package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * 优惠券
 */
public class Coupon extends BaseEntity {

    //名称
    private String name;
    //开始时间
    private String beginTime;
    //过期时间
    private String endTime;
    //1-代金券；2-折扣券
    private int type;
    //满减使用，抵扣金额
    private double reduceValue;
    //折扣使用，折扣率
    private double discountValue;
    //最大抵扣金额
    private double maxAmount;
    //达到该金额才可使用
    private  double constraintValue;
    //是否可以和其他优惠券同时使用：0-否；1-是。0优先级更高。
    private  byte sameUse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getReduceValue() {
        return reduceValue;
    }

    public void setReduceValue(double reduceValue) {
        this.reduceValue = reduceValue;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getConstraintValue() {
        return constraintValue;
    }

    public void setConstraintValue(double constraintValue) {
        this.constraintValue = constraintValue;
    }

    public byte getSameUse() {
        return sameUse;
    }

    public void setSameUse(byte sameUse) {
        this.sameUse = sameUse;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "name='" + name + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", type=" + type +
                ", reduceValue=" + reduceValue +
                ", discountValue=" + discountValue +
                ", maxAmount=" + maxAmount +
                ", constraintValue=" + constraintValue +
                ", sameUse=" + sameUse +
                '}';
    }
}
