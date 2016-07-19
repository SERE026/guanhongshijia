package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class HuiyuanInfoModel implements Serializable {
    private Integer id;

    private String address;

    private String birthday;

    private String email;

    private String name;

    private String password;

    private String phone;

    private String postcode;

    private String rank;

    private String sex;

    private String tel;

    private String username;

    private String cityId;

    private String provinceId;

    private String regionId;

    private String logindata;

    private String enterdata;

    private Integer count;

    private String status;

    private String shangId;

    private Integer jf;

    private String jfdata;

    private String nickname;

    private String idcard;

    private String phonestate;

    private String emlstate;

    private String txImage;

    private String qq;

    private String qqid;

    private Double money;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getLogindata() {
        return logindata;
    }

    public void setLogindata(String logindata) {
        this.logindata = logindata == null ? null : logindata.trim();
    }

    public String getEnterdata() {
        return enterdata;
    }

    public void setEnterdata(String enterdata) {
        this.enterdata = enterdata == null ? null : enterdata.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getShangId() {
        return shangId;
    }

    public void setShangId(String shangId) {
        this.shangId = shangId == null ? null : shangId.trim();
    }

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }

    public String getJfdata() {
        return jfdata;
    }

    public void setJfdata(String jfdata) {
        this.jfdata = jfdata == null ? null : jfdata.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhonestate() {
        return phonestate;
    }

    public void setPhonestate(String phonestate) {
        this.phonestate = phonestate == null ? null : phonestate.trim();
    }

    public String getEmlstate() {
        return emlstate;
    }

    public void setEmlstate(String emlstate) {
        this.emlstate = emlstate == null ? null : emlstate.trim();
    }

    public String getTxImage() {
        return txImage;
    }

    public void setTxImage(String txImage) {
        this.txImage = txImage == null ? null : txImage.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getQqid() {
        return qqid;
    }

    public void setQqid(String qqid) {
        this.qqid = qqid == null ? null : qqid.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}