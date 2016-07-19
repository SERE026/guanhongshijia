package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class BbsUserInfoModel implements Serializable {
    private Integer id;

    private String name;

    private String iamge;

    private Integer lev;

    private String bbsId;

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

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge == null ? null : iamge.trim();
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getBbsId() {
        return bbsId;
    }

    public void setBbsId(String bbsId) {
        this.bbsId = bbsId == null ? null : bbsId.trim();
    }
}