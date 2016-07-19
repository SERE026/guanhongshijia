package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.HuiyuanInfoModel;

import java.util.List;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class HuiyuanInfoDomain extends HuiyuanInfoModel {
    private AreaXInfoDomain province;
    private AreaXInfoDomain city;
    private AreaXInfoDomain region;
    private List<LoginfoDomain> log;
    private List<CommentInfoDomain> comment;

    public AreaXInfoDomain getProvince() {
        return province;
    }

    public void setProvince(AreaXInfoDomain province) {
        this.province = province;
    }

    public AreaXInfoDomain getCity() {
        return city;
    }

    public void setCity(AreaXInfoDomain city) {
        this.city = city;
    }

    public AreaXInfoDomain getRegion() {
        return region;
    }

    public void setRegion(AreaXInfoDomain region) {
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
