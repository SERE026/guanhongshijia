package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.ShowGoodModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class ShowGoodDomain extends ShowGoodModel {
    private GoodsDomain good;

    public GoodsDomain getGood() {
        return good;
    }

    public void setGood(GoodsDomain good) {
        this.good = good;
    }
}
