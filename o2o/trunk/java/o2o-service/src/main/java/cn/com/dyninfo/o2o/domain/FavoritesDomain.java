package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.FaoritesModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class FavoritesDomain extends FaoritesModel {
    private HuiyuanInfoDomain member;
    private GoodsDomain good;
    private ShangjiaInfoDomain shangJiaInfo;
    private ShangjiaInfoDomain merchant;

    public HuiyuanInfoDomain getMember() {
        return member;
    }

    public void setMember(HuiyuanInfoDomain member) {
        this.member = member;
    }

    public GoodsDomain getGood() {
        return good;
    }

    public void setGood(GoodsDomain good) {
        this.good = good;
    }

    public ShangjiaInfoDomain getShangJiaInfo() {
        return shangJiaInfo;
    }

    public void setShangJiaInfo(ShangjiaInfoDomain shangJiaInfo) {
        this.shangJiaInfo = shangJiaInfo;
    }

    public ShangjiaInfoDomain getMerchant() {
        return merchant;
    }

    public void setMerchant(ShangjiaInfoDomain merchant) {
        this.merchant = merchant;
    }
}
