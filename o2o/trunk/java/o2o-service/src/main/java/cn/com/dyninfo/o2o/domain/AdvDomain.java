package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AdvModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AdvDomain extends AdvModel {
    private AdvWzDomain advwzDomain;
    private AreaXInfoDomain areaInfoDomain;

    public AdvWzDomain getAdvwzDomain() {
        return advwzDomain;
    }

    public void setAdvwzDomain(AdvWzDomain advwzDomain) {
        this.advwzDomain = advwzDomain;
    }

    public AreaXInfoDomain getAreaInfoDomain() {
        return areaInfoDomain;
    }

    public void setAreaInfoDomain(AreaXInfoDomain areaInfoDomain) {
        this.areaInfoDomain = areaInfoDomain;
    }
}
