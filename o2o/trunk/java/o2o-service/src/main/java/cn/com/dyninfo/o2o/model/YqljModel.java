package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class YqljModel implements Serializable {
    private Integer id;

    private String name;

    private String dress;

    private Integer count;

    private String img;

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

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress == null ? null : dress.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}