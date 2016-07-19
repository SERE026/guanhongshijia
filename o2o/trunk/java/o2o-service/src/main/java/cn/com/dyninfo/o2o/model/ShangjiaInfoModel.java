package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class ShangjiaInfoModel implements Serializable {
    private Integer id;

    private String address;

    private String contactname;

    private String contactphone;

    private Float latitude;

    private Float longitude;

    private String name;

    private String orderIndex;

    private String intro;

    private String recommendedIndex;

    private String cityId;

    private String countId;

    private String provinceId;

    private String image;

    private String ps;

    private String state;

    private String userId;

    private String affiliation;

    private String appkey;

    private Integer nrjId;

    private Integer typeId;

    private Integer flag;

    private String dzIamge;

    private String nrjIamge;

    private Integer sort;

    private String dailiId;

    private String dzUrl;

    private Double money;

    private String qq;

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

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex == null ? null : orderIndex.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getRecommendedIndex() {
        return recommendedIndex;
    }

    public void setRecommendedIndex(String recommendedIndex) {
        this.recommendedIndex = recommendedIndex == null ? null : recommendedIndex.trim();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation == null ? null : affiliation.trim();
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public Integer getNrjId() {
        return nrjId;
    }

    public void setNrjId(Integer nrjId) {
        this.nrjId = nrjId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDzIamge() {
        return dzIamge;
    }

    public void setDzIamge(String dzIamge) {
        this.dzIamge = dzIamge == null ? null : dzIamge.trim();
    }

    public String getNrjIamge() {
        return nrjIamge;
    }

    public void setNrjIamge(String nrjIamge) {
        this.nrjIamge = nrjIamge == null ? null : nrjIamge.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId == null ? null : dailiId.trim();
    }

    public String getDzUrl() {
        return dzUrl;
    }

    public void setDzUrl(String dzUrl) {
        this.dzUrl = dzUrl == null ? null : dzUrl.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }
}