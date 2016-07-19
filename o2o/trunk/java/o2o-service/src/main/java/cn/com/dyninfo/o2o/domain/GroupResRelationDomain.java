package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ResControlRelModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GroupResRelationDomain extends ResControlRelModel {
    private ControlGroupInfoDomain controlGroupInfoDomain;
    private ResInfoDomain resInfoDomain;

    public ControlGroupInfoDomain getControlGroupInfoDomain() {
        return controlGroupInfoDomain;
    }

    public void setControlGroupInfoDomain(ControlGroupInfoDomain controlGroupInfoDomain) {
        this.controlGroupInfoDomain = controlGroupInfoDomain;
    }

    public ResInfoDomain getResInfoDomain() {
        return resInfoDomain;
    }

    public void setResInfoDomain(ResInfoDomain resInfoDomain) {
        this.resInfoDomain = resInfoDomain;
    }
}

