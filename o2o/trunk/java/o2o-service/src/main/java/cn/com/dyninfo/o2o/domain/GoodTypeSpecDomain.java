package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.GoodTypeSpecModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class GoodTypeSpecDomain extends GoodTypeSpecModel{

    private GoodsTypeDomain type;

    public GoodsTypeDomain getType() {
        return type;
    }

    public void setType(GoodsTypeDomain type) {
        this.type = type;
    }
}
