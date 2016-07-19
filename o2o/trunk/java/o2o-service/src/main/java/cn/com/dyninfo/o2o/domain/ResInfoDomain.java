package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ResInfoModel;

import java.util.List;
import java.util.Set;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ResInfoDomain extends ResInfoModel {
    private ResInfoDomain parent;
    private List<ResInfoDomain> children;
    private Set<FunctionInfoDomain> funs;
    private List<GroupResRelationDomain> grrList;

    public ResInfoDomain getParent() {
        return parent;
    }

    public void setParent(ResInfoDomain parent) {
        this.parent = parent;
    }

    public List<ResInfoDomain> getChildren() {
        return children;
    }

    public void setChildren(List<ResInfoDomain> children) {
        this.children = children;
    }

    public Set<FunctionInfoDomain> getFuns() {
        return funs;
    }

    public void setFuns(Set<FunctionInfoDomain> funs) {
        this.funs = funs;
    }

    public List<GroupResRelationDomain> getGrrList() {
        return grrList;
    }

    public void setGrrList(List<GroupResRelationDomain> grrList) {
        this.grrList = grrList;
    }
}
