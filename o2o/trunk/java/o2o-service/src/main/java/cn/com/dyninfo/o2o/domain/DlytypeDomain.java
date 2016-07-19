package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.DlyTypeModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class DlytypeDomain extends DlyTypeModel {
    private WlcompanyDomain wlcompanyDomain;
    private List<PsareaDomain> psareaDomainList;
    private ShangJiaInfoDomain shangJiaInfoDomain;

    public WlcompanyDomain getWlcompanyDomain() {
        return wlcompanyDomain;
    }

    public void setWlcompanyDomain(WlcompanyDomain wlcompanyDomain) {
        this.wlcompanyDomain = wlcompanyDomain;
    }

    public List<PsareaDomain> getPsareaDomainList() {
        return psareaDomainList;
    }

    public void setPsareaDomainList(List<PsareaDomain> psareaDomainList) {
        this.psareaDomainList = psareaDomainList;
    }

    public ShangJiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangJiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }
}
