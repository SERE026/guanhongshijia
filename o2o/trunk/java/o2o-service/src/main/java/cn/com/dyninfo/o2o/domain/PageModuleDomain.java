package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PageModuleModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PageModuleDomain extends PageModuleModel {
    private List<PagModInGoodsDomain> goodsList;

    public List<PagModInGoodsDomain> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<PagModInGoodsDomain> goodsList) {
        this.goodsList = goodsList;
    }
}
