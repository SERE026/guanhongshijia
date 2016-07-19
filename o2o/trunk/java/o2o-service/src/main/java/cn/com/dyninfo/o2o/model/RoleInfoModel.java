package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class RoleInfoModel implements Serializable {
    private Integer id;

    private Integer indexOrder;

    private String isSys;

    private String isJob;

    private String roleCName;

    private String roleEName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(Integer indexOrder) {
        this.indexOrder = indexOrder;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys == null ? null : isSys.trim();
    }

    public String getIsJob() {
        return isJob;
    }

    public void setIsJob(String isJob) {
        this.isJob = isJob == null ? null : isJob.trim();
    }

    public String getRoleCName() {
        return roleCName;
    }

    public void setRoleCName(String roleCName) {
        this.roleCName = roleCName == null ? null : roleCName.trim();
    }

    public String getRoleEName() {
        return roleEName;
    }

    public void setRoleEName(String roleEName) {
        this.roleEName = roleEName == null ? null : roleEName.trim();
    }
}