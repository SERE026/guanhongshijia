package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class FindPasswordModel implements Serializable {
    private Integer id;

    private String email;

    private String uuid;

    private String findtime;

    private String editstat;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getFindtime() {
        return findtime;
    }

    public void setFindtime(String findtime) {
        this.findtime = findtime == null ? null : findtime.trim();
    }

    public String getEditstat() {
        return editstat;
    }

    public void setEditstat(String editstat) {
        this.editstat = editstat == null ? null : editstat.trim();
    }
}