package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class UserInfoModel implements Serializable {
    private Integer id;

    private String loginId;

    private String email;

    private String img;

    private Integer indexOrder;

    private String isDefault;

    private String isused;

    private String mobile;

    private String offTel;

    private String passwd;

    private String userName;

    private Integer sinfoId;

    private String isUser;

    private String dailiId;

    private String areaname;

    private String areaid;

    private String areanmae;

    private String isxpsj;

    private Integer agentGradeId;

    private String ps;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(Integer indexOrder) {
        this.indexOrder = indexOrder;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused == null ? null : isused.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOffTel() {
        return offTel;
    }

    public void setOffTel(String offTel) {
        this.offTel = offTel == null ? null : offTel.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getSinfoId() {
        return sinfoId;
    }

    public void setSinfoId(Integer sinfoId) {
        this.sinfoId = sinfoId;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser == null ? null : isUser.trim();
    }

    public String getDailiId() {
        return dailiId;
    }

    public void setDailiId(String dailiId) {
        this.dailiId = dailiId == null ? null : dailiId.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getAreanmae() {
        return areanmae;
    }

    public void setAreanmae(String areanmae) {
        this.areanmae = areanmae == null ? null : areanmae.trim();
    }

    public String getIsxpsj() {
        return isxpsj;
    }

    public void setIsxpsj(String isxpsj) {
        this.isxpsj = isxpsj == null ? null : isxpsj.trim();
    }

    public Integer getAgentGradeId() {
        return agentGradeId;
    }

    public void setAgentGradeId(Integer agentGradeId) {
        this.agentGradeId = agentGradeId;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }
}