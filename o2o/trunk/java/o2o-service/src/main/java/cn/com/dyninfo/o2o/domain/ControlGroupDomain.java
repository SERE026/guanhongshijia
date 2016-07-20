package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ControlGroupModel;

import java.util.Set;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ControlGroupDomain extends ControlGroupModel {
    private Set<GroupResRelationDomain> groupResRelationDomainSet;
    private Set<RoleInfoDomain> roleInfoDomainSet;

    public Set<GroupResRelationDomain> getGroupResRelationDomainSet() {
        return groupResRelationDomainSet;
    }

    public void setGroupResRelationDomainSet(Set<GroupResRelationDomain> groupResRelationDomainSet) {
        this.groupResRelationDomainSet = groupResRelationDomainSet;
    }

    public Set<RoleInfoDomain> getRoleInfoDomainSet() {
        return roleInfoDomainSet;
    }

    public void setRoleInfoDomainSet(Set<RoleInfoDomain> roleInfoDomainSet) {
        this.roleInfoDomainSet = roleInfoDomainSet;
    }
}
