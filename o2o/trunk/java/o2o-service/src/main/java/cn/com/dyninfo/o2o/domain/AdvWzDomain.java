package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AdvWzModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AdvWzDomain extends AdvWzModel {
    private List<AdvWzDomain> AdvWzDomainList;

    public List<AdvWzDomain> getAdvWzDomainList() {
        return AdvWzDomainList;
    }

    public void setAdvWzDomainList(List<AdvWzDomain> advWzDomainList) {
        AdvWzDomainList = advWzDomainList;
    }
}
