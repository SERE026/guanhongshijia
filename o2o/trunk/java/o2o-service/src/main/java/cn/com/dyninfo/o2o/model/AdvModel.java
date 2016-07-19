package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class AdvModel implements Serializable {
    private Integer id;

    private String name;

    private String advwzId;

    private String advUse;

    private String starttime;

    private String endtime;

    private String link;

    private String file;

    private String unit;

    private String linkman;

    private String linktype;

    private Integer hits;

    private String areaId;

    private String advBgcolor;

    private Integer orderIndex;

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

    public String getAdvwzId() {
        return advwzId;
    }

    public void setAdvwzId(String advwzId) {
        this.advwzId = advwzId == null ? null : advwzId.trim();
    }

    public String getAdvUse() {
        return advUse;
    }

    public void setAdvUse(String advUse) {
        this.advUse = advUse == null ? null : advUse.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinktype() {
        return linktype;
    }

    public void setLinktype(String linktype) {
        this.linktype = linktype == null ? null : linktype.trim();
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAdvBgcolor() {
        return advBgcolor;
    }

    public void setAdvBgcolor(String advBgcolor) {
        this.advBgcolor = advBgcolor == null ? null : advBgcolor.trim();
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}