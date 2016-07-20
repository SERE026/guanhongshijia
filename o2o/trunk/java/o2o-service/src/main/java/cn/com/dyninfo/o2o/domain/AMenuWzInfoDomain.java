package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AMenuWzInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AMenuWzInfoDomain extends AMenuWzInfoModel {

    private List<AMenuInfoDomain> amenuInfoDomainList;

    public List<AMenuInfoDomain> getAmenuInfoDomainList() {
        return amenuInfoDomainList;
    }

    public void setAmenuInfoDomainList(List<AMenuInfoDomain> amenuInfoDomainList) {
        this.amenuInfoDomainList = amenuInfoDomainList;
    }
}
