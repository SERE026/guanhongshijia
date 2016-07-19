package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class JfFaModel implements Serializable {
    private Integer id;

    private Integer xfjf;

    private Double jfdk;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXfjf() {
        return xfjf;
    }

    public void setXfjf(Integer xfjf) {
        this.xfjf = xfjf;
    }

    public Double getJfdk() {
        return jfdk;
    }

    public void setJfdk(Double jfdk) {
        this.jfdk = jfdk;
    }
}