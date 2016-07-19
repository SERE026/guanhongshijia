package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class NrjModel implements Serializable {
    private Integer id;

    private Integer nrjCount;

    private Integer shangjiaId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNrjCount() {
        return nrjCount;
    }

    public void setNrjCount(Integer nrjCount) {
        this.nrjCount = nrjCount;
    }

    public Integer getShangjiaId() {
        return shangjiaId;
    }

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
}