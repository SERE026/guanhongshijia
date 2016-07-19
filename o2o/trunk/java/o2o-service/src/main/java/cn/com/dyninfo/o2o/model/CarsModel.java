package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class CarsModel implements Serializable {
    private Integer id;

    private Integer huiyuanId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHuiyuanId() {
        return huiyuanId;
    }

    public void setHuiyuanId(Integer huiyuanId) {
        this.huiyuanId = huiyuanId;
    }
}