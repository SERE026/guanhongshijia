package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.HuiyuanInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class HuiyuanInfoDomain extends HuiyuanInfoModel {
    private AreaInfoDomain province;
    private AreaInfoDomain city;
    private AreaInfoDomain region;
    private List<LoginfoDomain> log;
    private List<CommentInfoDomain> comment;

    public AreaInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaInfoDomain province) {
        this.province = province;
    }

    public AreaInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaInfoDomain city) {
        this.city = city;
    }

    public AreaInfoDomain getRegion() {
        return region;
    }

    public void setRegion(AreaInfoDomain region) {
        this.region = region;
    }

    public List<LoginfoDomain> getLog() {
        return log;
    }

    public void setLog(List<LoginfoDomain> log) {
        this.log = log;
    }

    public List<CommentInfoDomain> getComment() {
        return comment;
    }

    public void setComment(List<CommentInfoDomain> comment) {
        this.comment = comment;
    }
}
