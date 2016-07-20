package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodsSortModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodsSortDomain extends GoodsSortModel {
    private GoodsSortDomain parent;
    private List<GoodsSortDomain> children;
    private GoodsTypeDomain type;
    private ShangjiaInfoDomain merchants;

    public GoodsSortDomain getParent() {
        return parent;
    }

    public void setParent(GoodsSortDomain parent) {
        this.parent = parent;
    }

    public List<GoodsSortDomain> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsSortDomain> children) {
        this.children = children;
    }

    public GoodsTypeDomain getType() {
        return type;
    }

    public void setType(GoodsTypeDomain type) {
        this.type = type;
    }

    public ShangjiaInfoDomain getMerchants() {
        return merchants;
    }

    public void setMerchants(ShangjiaInfoDomain merchants) {
        this.merchants = merchants;
    }
}
