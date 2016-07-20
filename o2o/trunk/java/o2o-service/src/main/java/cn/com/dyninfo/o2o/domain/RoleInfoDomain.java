package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.RoleInfoModel;

import java.util.Set;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class RoleInfoDomain extends RoleInfoModel {
    private Set<ControlGroupDomain> groups;
    private Set<UserInfoDomain> user;

    public Set<ControlGroupDomain> getGroups() {
        return groups;
    }

    public void setGroups(Set<ControlGroupDomain> groups) {
        this.groups = groups;
    }

    public Set<UserInfoDomain> getUser() {
        return user;
    }

    public void setUser(Set<UserInfoDomain> user) {
        this.user = user;
    }
}
