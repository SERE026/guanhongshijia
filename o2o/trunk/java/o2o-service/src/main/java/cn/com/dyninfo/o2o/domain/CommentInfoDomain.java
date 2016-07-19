package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.CommentInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class CommentInfoDomain extends CommentInfoModel{
    private HuiyuanInfoDomain huiyuanInfoDomain;
    private UserInfoDomain userInfoDomain;
    private ShangJiaInfoDomain shangJiaInfoDomain;
    private GoodsDomain goodsDomain;

    public HuiyuanInfoDomain getHuiyuanInfoDomain() {
        return huiyuanInfoDomain;
    }

    public void setHuiyuanInfoDomain(HuiyuanInfoDomain huiyuanInfoDomain) {
        this.huiyuanInfoDomain = huiyuanInfoDomain;
    }

    public UserInfoDomain getUserInfoDomain() {
        return userInfoDomain;
    }

    public void setUserInfoDomain(UserInfoDomain userInfoDomain) {
        this.userInfoDomain = userInfoDomain;
    }

    public ShangJiaInfoDomain getShangJiaInfoDomain() {
        return shangJiaInfoDomain;
    }

    public void setShangJiaInfoDomain(ShangJiaInfoDomain shangJiaInfoDomain) {
        this.shangJiaInfoDomain = shangJiaInfoDomain;
    }

    public GoodsDomain getGoodsDomain() {
        return goodsDomain;
    }

    public void setGoodsDomain(GoodsDomain goodsDomain) {
        this.goodsDomain = goodsDomain;
    }
}
