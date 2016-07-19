package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class WlCompanyModel implements Serializable {
    private Integer id;

    private String nmae;

    private String englishname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmae() {
        return nmae;
    }

    public void setNmae(String nmae) {
        this.nmae = nmae == null ? null : nmae.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }
}