package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AdvModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AdvDomain extends AdvModel {
    private AdvwzDomain advwzDomain;
    private AreaInfoDomain areaInfoDomain;

    public AdvwzDomain getAdvwzDomain() {
        return advwzDomain;
    }

    public void setAdvwzDomain(AdvwzDomain advwzDomain) {
        this.advwzDomain = advwzDomain;
    }

    public AreaInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }
}
