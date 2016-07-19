package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.TradeInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class TradeInfoDomain extends TradeInfoModel {
    private HuiyuanInfoDomain huiyuan;
    private ZffsDomain zffs;

    public ZffsDomain getZffs() {
        return zffs;
    }

    public void setZffs(ZffsDomain zffs) {
        this.zffs = zffs;
    }

    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }


}
