package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class DeliverDlyModel implements Serializable {
    private Integer id;

    private Integer deliverId;

    private Integer dlyId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
    }

    public Integer getDlyId() {
        return dlyId;
    }

    public void setDlyId(Integer dlyId) {
        this.dlyId = dlyId;
    }
}