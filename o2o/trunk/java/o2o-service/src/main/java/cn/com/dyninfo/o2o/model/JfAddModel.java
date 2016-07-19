package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class JfAddModel implements Serializable {
    private Integer id;

    private String name;

    private Float zjjf;

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

    public Float getZjjf() {
        return zjjf;
    }

    public void setZjjf(Float zjjf) {
        this.zjjf = zjjf;
    }
}