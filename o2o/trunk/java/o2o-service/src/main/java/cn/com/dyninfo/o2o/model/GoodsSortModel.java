package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodsSortModel implements Serializable {
    private Integer id;

    private String name;

    private String ps;

    private String status;

    private String imagesrc;

    private Integer parentId;

    private Integer typeId;

    private String flag;

    private Integer marchantsId;

    private Integer tIndex;

    private String reveal;

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

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc == null ? null : imagesrc.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Integer getMarchantsId() {
        return marchantsId;
    }

    public void setMarchantsId(Integer marchantsId) {
        this.marchantsId = marchantsId;
    }

    public Integer gettIndex() {
        return tIndex;
    }

    public void settIndex(Integer tIndex) {
        this.tIndex = tIndex;
    }

    public String getReveal() {
        return reveal;
    }

    public void setReveal(String reveal) {
        this.reveal = reveal == null ? null : reveal.trim();
    }
}