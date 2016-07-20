package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.HuiyuanInfoModel;
import cn.com.dyninfo.o2o.model.HuiyuanMoneyModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class HuiyuanMoneyDomain extends HuiyuanMoneyModel{
    private OrderDomain order;
    private HuiyuanInfoDomain huiyuan;

    public OrderDomain getOrder() {
        return order;
    }

    public void setOrder(OrderDomain order) {
        this.order = order;
    }

    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }
}
