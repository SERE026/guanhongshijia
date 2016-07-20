package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PSAreaModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PSAreaDomain extends PSAreaModel {
    private DlyTypeDomain dlytype;

    public DlyTypeDomain getDlytype() {
        return dlytype;
    }

    public void setDlytype(DlyTypeDomain dlytype) {
        this.dlytype = dlytype;
    }
}
