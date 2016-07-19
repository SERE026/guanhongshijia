package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class ResControlRelModel implements Serializable {
    private Integer id;

    private String accessobj;

    private String accesstype;

    private String groupId;

    private String rcId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessobj() {
        return accessobj;
    }

    public void setAccessobj(String accessobj) {
        this.accessobj = accessobj == null ? null : accessobj.trim();
    }

    public String getAccesstype() {
        return accesstype;
    }

    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype == null ? null : accesstype.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getRcId() {
        return rcId;
    }

    public void setRcId(String rcId) {
        this.rcId = rcId == null ? null : rcId.trim();
    }
}