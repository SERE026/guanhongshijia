package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AAdvInfoModel;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class AAdvInfoDomain extends AAdvInfoModel {

    private List<AdvGoodsDomain> goodsDomainList;

    public List<AdvGoodsDomain> getGoodsDomainList() {
        return goodsDomainList;
    }

    public void setGoodsDomainList(List<AdvGoodsDomain> goodsDomainList) {
        this.goodsDomainList = goodsDomainList;
    }
}
