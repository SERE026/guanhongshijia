package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class PageModuleInGoodsModel implements Serializable {
    private Integer id;

    private Integer pagemoduleId;

    private Integer goodId;

    private Integer indexs;

    private String expireTime;

    private Integer shangjiainfoId;

    private String cityId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPagemoduleId() {
        return pagemoduleId;
    }

    public void setPagemoduleId(Integer pagemoduleId) {
        this.pagemoduleId = pagemoduleId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getIndexs() {
        return indexs;
    }

    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime == null ? null : expireTime.trim();
    }

    public Integer getShangjiainfoId() {
        return shangjiainfoId;
    }

    public void setShangjiainfoId(Integer shangjiainfoId) {
        this.shangjiainfoId = shangjiainfoId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }
}