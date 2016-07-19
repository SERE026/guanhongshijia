package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class OrderProductModel implements Serializable {
    private Integer id;

    private Double actMoney;

    private Double goodMoney;

    private String goodsSpec;

    private Integer goodNum;

    private Double widget;

    private Integer actId;

    private String orderId;

    private Integer productId;

    private String showStats;

    private Integer actGameId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getActMoney() {
        return actMoney;
    }

    public void setActMoney(Double actMoney) {
        this.actMoney = actMoney;
    }

    public Double getGoodMoney() {
        return goodMoney;
    }

    public void setGoodMoney(Double goodMoney) {
        this.goodMoney = goodMoney;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Double getWidget() {
        return widget;
    }

    public void setWidget(Double widget) {
        this.widget = widget;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getShowStats() {
        return showStats;
    }

    public void setShowStats(String showStats) {
        this.showStats = showStats == null ? null : showStats.trim();
    }

    public Integer getActGameId() {
        return actGameId;
    }

    public void setActGameId(Integer actGameId) {
        this.actGameId = actGameId;
    }
}