package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.LogInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class LogInfoDomain extends LogInfoModel {
    public HuiyuanInfoDomain getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(HuiyuanInfoDomain huiyuan) {
        this.huiyuan = huiyuan;
    }

    private HuiyuanInfoDomain huiyuan;
}
