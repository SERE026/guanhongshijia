package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class MerchantsApplyModel implements Serializable {
    private Integer id;

    private String address;

    private String companyName;

    private String contatctEmail;

    private String contatctMan;

    private String contatctPhone;

    private String state;

    private String storeName;

    private Integer storeType;

    private String cityId;

    private String countId;

    private String provinceId;

    private Integer busType;

    private String contatctTel;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getContatctEmail() {
        return contatctEmail;
    }

    public void setContatctEmail(String contatctEmail) {
        this.contatctEmail = contatctEmail == null ? null : contatctEmail.trim();
    }

    public String getContatctMan() {
        return contatctMan;
    }

    public void setContatctMan(String contatctMan) {
        this.contatctMan = contatctMan == null ? null : contatctMan.trim();
    }

    public String getContatctPhone() {
        return contatctPhone;
    }

    public void setContatctPhone(String contatctPhone) {
        this.contatctPhone = contatctPhone == null ? null : contatctPhone.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId == null ? null : countId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public Integer getBusType() {
        return busType;
    }

    public void setBusType(Integer busType) {
        this.busType = busType;
    }

    public String getContatctTel() {
        return contatctTel;
    }

    public void setContatctTel(String contatctTel) {
        this.contatctTel = contatctTel == null ? null : contatctTel.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}