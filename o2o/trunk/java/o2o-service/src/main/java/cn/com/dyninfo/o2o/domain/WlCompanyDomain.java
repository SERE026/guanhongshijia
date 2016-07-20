package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.WlCompanyModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class WlCompanyDomain extends WlCompanyModel {
    private List<DlyTypeDomain> dlytype;

    public List<DlyTypeDomain> getDlytype() {
        return dlytype;
    }

    public void setDlytype(List<DlyTypeDomain> dlytype) {
        this.dlytype = dlytype;
    }
}
