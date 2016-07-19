package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class OgnzInfoModel implements Serializable {
    private Integer id;

    private Integer indexOrder;

    private String isused;

    private String isognz;

    private String ognzName;

    private String parentId;

    private String ps;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(Integer indexOrder) {
        this.indexOrder = indexOrder;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused == null ? null : isused.trim();
    }

    public String getIsognz() {
        return isognz;
    }

    public void setIsognz(String isognz) {
        this.isognz = isognz == null ? null : isognz.trim();
    }

    public String getOgnzName() {
        return ognzName;
    }

    public void setOgnzName(String ognzName) {
        this.ognzName = ognzName == null ? null : ognzName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }
}