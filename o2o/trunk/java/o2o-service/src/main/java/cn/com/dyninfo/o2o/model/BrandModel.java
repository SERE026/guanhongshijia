package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class BrandModel implements Serializable {
    private Integer id;

    private String name;

    private String logo;

    private String provider;

    private String providerPhone;

    private String providerMovable;

    private String providerAddress;

    private String status;

    private String ps;

    private Integer tIndex;

    private String isR;

    private String flag;

    private String marchantsId;

    private String paixu;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone == null ? null : providerPhone.trim();
    }

    public String getProviderMovable() {
        return providerMovable;
    }

    public void setProviderMovable(String providerMovable) {
        this.providerMovable = providerMovable == null ? null : providerMovable.trim();
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress == null ? null : providerAddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public Integer gettIndex() {
        return tIndex;
    }

    public void settIndex(Integer tIndex) {
        this.tIndex = tIndex;
    }

    public String getIsR() {
        return isR;
    }

    public void setIsR(String isR) {
        this.isR = isR == null ? null : isR.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getMarchantsId() {
        return marchantsId;
    }

    public void setMarchantsId(String marchantsId) {
        this.marchantsId = marchantsId == null ? null : marchantsId.trim();
    }

    public String getPaixu() {
        return paixu;
    }

    public void setPaixu(String paixu) {
        this.paixu = paixu == null ? null : paixu.trim();
    }
}