package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class TradeInfoModel implements Serializable {
    private Integer id;

    private String tradeId;

    private Double money;

    private Integer status;

    private Integer zffsId;

    private String trade;

    private Integer flag;

    private Integer huiyuanId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getZffsId() {
        return zffsId;
    }

    public void setZffsId(Integer zffsId) {
        this.zffsId = zffsId;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade == null ? null : trade.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getHuiyuanId() {
        return huiyuanId;
    }

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }
}