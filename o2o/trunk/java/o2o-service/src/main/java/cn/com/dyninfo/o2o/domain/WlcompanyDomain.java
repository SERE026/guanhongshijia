package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.WlCompanyModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class WlcompanyDomain extends WlCompanyModel {
    private List<DlytypeDomain> dlytype;

    public List<DlytypeDomain> getDlytype() {
        return dlytype;
    }

    public void setDlytype(List<DlytypeDomain> dlytype) {
        this.dlytype = dlytype;
    }
}
