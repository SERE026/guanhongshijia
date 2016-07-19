package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class DlyTypeModel implements Serializable {
    private Integer id;

    private String dlynmae;

    private Double firstwt;

    private Double addwt;

    private Double firstmoney;

    private Double addwtmoney;

    private Double bjfl;

    private Double lowest;

    private String valuation;

    private String paytype;

    private String valuetype;

    private String stats;

    private String detailed;

    private Integer count;

    private Integer wlcompanyId;

    private String mrfr;

    private Double mrscfr;

    private Double mrxzfr;

    private String stat;

    private Integer marchantsId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDlynmae() {
        return dlynmae;
    }

    public void setDlynmae(String dlynmae) {
        this.dlynmae = dlynmae == null ? null : dlynmae.trim();
    }

    public Double getFirstwt() {
        return firstwt;
    }

    public void setFirstwt(Double firstwt) {
        this.firstwt = firstwt;
    }

    public Double getAddwt() {
        return addwt;
    }

    public void setAddwt(Double addwt) {
        this.addwt = addwt;
    }

    public Double getFirstmoney() {
        return firstmoney;
    }

    public void setFirstmoney(Double firstmoney) {
        this.firstmoney = firstmoney;
    }

    public Double getAddwtmoney() {
        return addwtmoney;
    }

    public void setAddwtmoney(Double addwtmoney) {
        this.addwtmoney = addwtmoney;
    }

    public Double getBjfl() {
        return bjfl;
    }

    public void setBjfl(Double bjfl) {
        this.bjfl = bjfl;
    }

    public Double getLowest() {
        return lowest;
    }

    public void setLowest(Double lowest) {
        this.lowest = lowest;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation == null ? null : valuation.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype == null ? null : valuetype.trim();
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats == null ? null : stats.trim();
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed == null ? null : detailed.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWlcompanyId() {
        return wlcompanyId;
    }

    public void setWlcompanyId(Integer wlcompanyId) {
        this.wlcompanyId = wlcompanyId;
    }

    public String getMrfr() {
        return mrfr;
    }

    public void setMrfr(String mrfr) {
        this.mrfr = mrfr == null ? null : mrfr.trim();
    }

    public Double getMrscfr() {
        return mrscfr;
    }

    public void setMrscfr(Double mrscfr) {
        this.mrscfr = mrscfr;
    }

    public Double getMrxzfr() {
        return mrxzfr;
    }

    public void setMrxzfr(Double mrxzfr) {
        this.mrxzfr = mrxzfr;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public Integer getMarchantsId() {
        return marchantsId;
    }

    public void setMarchantsId(Integer marchantsId) {
        this.marchantsId = marchantsId;
    }
}