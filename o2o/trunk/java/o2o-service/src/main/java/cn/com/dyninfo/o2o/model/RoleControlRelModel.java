package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class RoleControlRelModel implements Serializable {
    private Integer roleId;

    private Integer groupId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}