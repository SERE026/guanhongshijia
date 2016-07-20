package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PageModuleModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PageModuleDomain extends PageModuleModel {
    private List<PageModuleInGoodsDomain> goodsList;

    public List<PageModuleInGoodsDomain> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<PageModuleInGoodsDomain> goodsList) {
        this.goodsList = goodsList;
    }
}
