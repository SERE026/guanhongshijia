package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AAdvWzInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AAdvWzInfoDomain extends AAdvWzInfoModel {
    private List<AAdvInfoDomain> aAdvInfoDomainList;
    public List<AAdvInfoDomain> getaAdvInfoDomainList() {
        return aAdvInfoDomainList;
    }

    public void setaAdvInfoDomainList(List<AAdvInfoDomain> aAdvInfoDomainList) {
        this.aAdvInfoDomainList = aAdvInfoDomainList;
    }


}
