package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.PageModuleInGoodsModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class PagModInGoodsDomain extends PageModuleInGoodsModel {
    private PageModuleDomain pageModule;
    private ShangJiaInfoDomain shangJiaInfo;
    private GoodsDomain goods;
    private AreaXInfoDomain city;

    public PageModuleDomain getPageModule() {
        return pageModule;
    }

    public void setPageModule(PageModuleDomain pageModule) {
        this.pageModule = pageModule;
    }

    public ShangJiaInfoDomain getShangJiaInfo() {
        return shangJiaInfo;
    }

    public void setShangJiaInfo(ShangJiaInfoDomain shangJiaInfo) {
        this.shangJiaInfo = shangJiaInfo;
    }

    public AreaXInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaXInfoDomain city) {
        this.city = city;
    }

    public GoodsDomain getGoods() {
        return goods;
    }

    public void setGoods(GoodsDomain goods) {
        this.goods = goods;
    }
}
