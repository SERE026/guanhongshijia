package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class PSAreaModel implements Serializable {
    private Integer id;

    private String areanmae;

    private Double mrscfr;

    private Double mrxzfr;

    private String paytype;

    private Integer dlytypeId;

    private String areaid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreanmae() {
        return areanmae;
    }

    public void setAreanmae(String areanmae) {
        this.areanmae = areanmae == null ? null : areanmae.trim();
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

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getDlytypeId() {
        return dlytypeId;
    }

    public void setDlytypeId(Integer dlytypeId) {
        this.dlytypeId = dlytypeId;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }
}