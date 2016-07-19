package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class ShowGoodModel implements Serializable {
    private Integer id;

    private String showGoodId;

    private String clinetId;

    private Integer time;

    private Integer goodId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShowGoodId() {
        return showGoodId;
    }

    public void setShowGoodId(String showGoodId) {
        this.showGoodId = showGoodId == null ? null : showGoodId.trim();
    }

    public String getClinetId() {
        return clinetId;
    }

    public void setClinetId(String clinetId) {
        this.clinetId = clinetId == null ? null : clinetId.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}