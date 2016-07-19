package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class AAdvInfoModel implements Serializable {
    private Integer id;

    private String img;

    private String name;

    private Integer aadvwzId;

    private String areaId;

    private Integer orderIndex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAadvwzId() {
        return aadvwzId;
    }

    public void setAadvwzId(Integer aadvwzId) {
        this.aadvwzId = aadvwzId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}