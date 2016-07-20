package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.NrjModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class NrjDomain extends NrjModel {
    public ShangjiaInfoDomain getShangJiaInfo() {
        return shangJiaInfo;
    }

    public void setShangJiaInfo(ShangjiaInfoDomain shangJiaInfo) {
        this.shangJiaInfo = shangJiaInfo;
    }

    private ShangjiaInfoDomain shangJiaInfo;
}
