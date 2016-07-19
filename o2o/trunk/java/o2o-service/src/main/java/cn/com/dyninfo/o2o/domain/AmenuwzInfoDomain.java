package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AMenuWzInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AmenuwzInfoDomain extends AMenuWzInfoModel {

    private List<AmenuInfoDomain> amenuInfoDomainList;

    public List<AmenuInfoDomain> getAmenuInfoDomainList() {
        return amenuInfoDomainList;
    }

    public void setAmenuInfoDomainList(List<AmenuInfoDomain> amenuInfoDomainList) {
        this.amenuInfoDomainList = amenuInfoDomainList;
    }
}
