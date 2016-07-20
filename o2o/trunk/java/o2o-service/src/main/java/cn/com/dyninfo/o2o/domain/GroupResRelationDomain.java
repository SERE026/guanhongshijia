package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ResControlRelModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GroupResRelationDomain extends ResControlRelModel {
    private ControlGroupDomain controlGroupInfoDomain;
    private ResInfoDomain resInfoDomain;

    public ControlGroupDomain getControlGroupInfoDomain() {
        return controlGroupInfoDomain;
    }

    public void setControlGroupInfoDomain(ControlGroupDomain controlGroupInfoDomain) {
        this.controlGroupInfoDomain = controlGroupInfoDomain;
    }

    public ResInfoDomain getResInfoDomain() {
        return resInfoDomain;
    }

    public void setResInfoDomain(ResInfoDomain resInfoDomain) {
        this.resInfoDomain = resInfoDomain;
    }
}

