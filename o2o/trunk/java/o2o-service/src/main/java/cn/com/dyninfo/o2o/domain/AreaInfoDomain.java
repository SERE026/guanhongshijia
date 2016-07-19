package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AreaXInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AreaInfoDomain extends AreaXInfoModel {
    private List<AreaInfoDomain> areaInfoDomainList;
    private AreaInfoDomain areaInfoDomain;

    public AreaInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }

    public List<AreaInfoDomain> getAreaInfoDomainList() {
        return areaInfoDomainList;
    }

    public void setAreaInfoDomainList(List<AreaInfoDomain> areaInfoDomainList) {
        this.areaInfoDomainList = areaInfoDomainList;
    }
}
