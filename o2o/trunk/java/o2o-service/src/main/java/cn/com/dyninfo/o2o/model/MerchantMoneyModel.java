package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class MerchantMoneyModel implements Serializable {
    private Integer id;

    private String brankCard;

    private String brankName;

    private Integer flag;

    private Double money;

    private String ps;

    private Integer type;

    private Integer huiyuanId;

    private Integer merchantId;

    private Integer shangjiaId;

    private String time;

    private String orderId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrankCard() {
        return brankCard;
    }

    public void setBrankCard(String brankCard) {
        this.brankCard = brankCard == null ? null : brankCard.trim();
    }

    public String getBrankName() {
        return brankName;
    }

    public void setBrankName(String brankName) {
        this.brankName = brankName == null ? null : brankName.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHuiyuanId() {
        return huiyuanId;
    }

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getShangjiaId() {
        return shangjiaId;
    }

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}