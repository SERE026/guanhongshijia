package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class GoodsTypeModel implements Serializable {
    private Integer id;

    private String name;

    private String status;

    private String linkbrank;

    private String ownspec;

    private String ps;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLinkbrank() {
        return linkbrank;
    }

    public void setLinkbrank(String linkbrank) {
        this.linkbrank = linkbrank == null ? null : linkbrank.trim();
    }

    public String getOwnspec() {
        return ownspec;
    }

    public void setOwnspec(String ownspec) {
        this.ownspec = ownspec == null ? null : ownspec.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }
}