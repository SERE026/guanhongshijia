package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.OgnzInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class OgnzInfoDomain extends OgnzInfoModel {
    private OgnzInfoDomain parent;
    private List<OgnzInfoDomain> children;
    private List<UserInfoDomain> users;

    public OgnzInfoDomain getParent() {
        return parent;
    }

    public void setParent(OgnzInfoDomain parent) {
        this.parent = parent;
    }

    public List<OgnzInfoDomain> getChildren() {
        return children;
    }

    public void setChildren(List<OgnzInfoDomain> children) {
        this.children = children;
    }

    public List<UserInfoDomain> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfoDomain> users) {
        this.users = users;
    }
}
