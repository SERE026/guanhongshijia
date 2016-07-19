package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PSAreaModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PsareaDomain extends PSAreaModel {
    private DlytypeDomain dlytype;

    public DlytypeDomain getDlytype() {
        return dlytype;
    }

    public void setDlytype(DlytypeDomain dlytype) {
        this.dlytype = dlytype;
    }
}
