package cn.com.dyninfo.o2o.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponModel implements Serializable {
    private Integer id;

    private String name;

    private Date beginTime;

    private Date endTime;

    private Boolean type;

    private BigDecimal reduceValue;

    private BigDecimal discountValue;

    private BigDecimal maxAmouont;

    private BigDecimal constraintValue;

    private Boolean sameUse;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public BigDecimal getReduceValue() {
        return reduceValue;
    }

    public void setReduceValue(BigDecimal reduceValue) {
        this.reduceValue = reduceValue;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getMaxAmouont() {
        return maxAmouont;
    }

    public void setMaxAmouont(BigDecimal maxAmouont) {
        this.maxAmouont = maxAmouont;
    }

    public BigDecimal getConstraintValue() {
        return constraintValue;
    }

    public void setConstraintValue(BigDecimal constraintValue) {
        this.constraintValue = constraintValue;
    }

    public Boolean getSameUse() {
        return sameUse;
    }

    public void setSameUse(Boolean sameUse) {
        this.sameUse = sameUse;
    }
}