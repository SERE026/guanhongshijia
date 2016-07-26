package cn.com.dyninfo.o2o.furniture.admin.model;

import org.hibernate.annotations.AccessType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zengrc on 2016/7/26.
 */

@Entity
@Table(name="t_coupon")
public class Coupon implements Serializable {


    @Id
    @AccessType(value = "property")
    @Column(name="ID")
    private int id;

    @AccessType(value = "property")
    @Column(name="NAME")
    private  String name;

    @AccessType(value = "property")
    @Column(name="BEGIN_TIME ")
    private Date beginTime;

    @AccessType(value = "property")
    @Column(name = "END_TIME")
    private Date endTime;

    @AccessType(value = "property")
    @Column(name = "TYPE")
    private  byte type;     //1-满减；2-折扣

    @AccessType(value = "property")
    @Column(name = "REDUCE_VALUE")
    private double reduceValue;  //满减使用，抵扣金额

    @AccessType(value = "property")
    @Column(name = "DISCOUNT_VALUE")
    private double discountValue;   //折扣使用，折扣率

    @AccessType(value = "property")
    @Column(name = "MAX_AMOUONT")
    private double maxAmouont;   //最大抵扣金额

    @AccessType(value = "property")
    @Column(name = "CONSTRAINT_VALUE")
    private  double constraintValue;   //达到该金额才可使用

    @AccessType(value = "property")
    @Column(name = "SAME_USE")
    private  byte sameUse;     //是否可以和其他优惠券同时使用：0-否；1-是。0优先级更高。

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getBeginTime() { return beginTime; }

    public void setBeginTime(Date beginTime) { this.beginTime = beginTime; }

    public Date getEndTime() { return endTime; }

    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public byte getType() { return type; }

    public void setType(byte type) { this.type = type; }

    public double getReduceValue() { return reduceValue; }

    public void setReduceValue(double reduceValue) { this.reduceValue = reduceValue; }

    public double getDiscountValue() { return discountValue; }

    public void setDiscountValue(double discountValue) { this.discountValue = discountValue; }

    public double getMaxAmouont() { return maxAmouont; }

    public void setMaxAmouont(double maxAmouont) { this.maxAmouont = maxAmouont; }

    public double getConstraintValue() { return constraintValue;}

    public void setConstraintValue(double constraintValue) { this.constraintValue = constraintValue; }

    public byte getSameUse() { return sameUse; }

    public void setSameUse(byte sameUse) { this.sameUse = sameUse; }
}
