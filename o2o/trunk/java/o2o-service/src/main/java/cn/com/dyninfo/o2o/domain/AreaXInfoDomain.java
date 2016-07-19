package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AreaXInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AreaXInfoDomain extends AreaXInfoModel {
    private List<AreaXInfoDomain> areaInfoDomainList;
    private AreaXInfoDomain areaInfoDomain;

    public AreaXInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaXInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }

    public List<AreaXInfoDomain> getAreaInfoDomainList() {
        return areaInfoDomainList;
    }

    public void setAreaInfoDomainList(List<AreaXInfoDomain> areaInfoDomainList) {
        this.areaInfoDomainList = areaInfoDomainList;
    }
}
