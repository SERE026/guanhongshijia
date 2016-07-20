package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.DlyTypeModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class DlyTypeDomain extends DlyTypeModel {
    private WlCompanyDomain wlcompanyDomain;
    private List<PSAreaDomain> psareaDomainList;
    private ShangjiaInfoDomain shangJiaInfoDomain;

    public WlCompanyDomain getWlcompanyDomain() {
        return wlcompanyDomain;
    }

    public void setWlcompanyDomain(WlCompanyDomain wlcompanyDomain) {
        this.wlcompanyDomain = wlcompanyDomain;
    }

    public List<PSAreaDomain> getPsareaDomainList() {
        return psareaDomainList;
    }

    public void setPsareaDomainList(List<PSAreaDomain> psareaDomainList) {
        this.psareaDomainList = psareaDomainList;
    }

    public ShangjiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangjiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }
}
