package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class MerchantOrderInfoModel implements Serializable {
    private Integer id;

    private Integer merchantId;

    private Integer orderId;

    private Integer tIndex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer gettIndex() {
        return tIndex;
    }

    public void settIndex(Integer tIndex) {
        this.tIndex = tIndex;
    }
}