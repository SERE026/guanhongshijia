package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class AMenuInfoModel implements Serializable {
    private Integer id;

    private String name;

    private String img;

    private Integer amenuwzId;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getAmenuwzId() {
        return amenuwzId;
    }

    public void setAmenuwzId(Integer amenuwzId) {
        this.amenuwzId = amenuwzId;
    }
}