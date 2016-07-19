package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class BrandOrderModel implements Serializable {
    private Integer id;

    private String brandId;

    private Integer indexs;

    private Integer brandMerchantsId;

    private String cityId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public Integer getIndexs() {
        return indexs;
    }

    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

    public Integer getBrandMerchantsId() {
        return brandMerchantsId;
    }

    public void setBrandMerchantsId(Integer brandMerchantsId) {
        this.brandMerchantsId = brandMerchantsId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }
}