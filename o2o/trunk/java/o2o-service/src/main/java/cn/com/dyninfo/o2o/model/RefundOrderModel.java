package cn.com.dyninfo.o2o.model;

import java.io.Serializable;
import java.util.Date;

public class RefundOrderModel implements Serializable {
    private Integer id;

    private Double refundmoney;

    private String status;

    private Date date;

    private String ps;

    private String reasonType;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRefundmoney() {
        return refundmoney;
    }

    public void setRefundmoney(Double refundmoney) {
        this.refundmoney = refundmoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonType) {
        this.reasonType = reasonType == null ? null : reasonType.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}