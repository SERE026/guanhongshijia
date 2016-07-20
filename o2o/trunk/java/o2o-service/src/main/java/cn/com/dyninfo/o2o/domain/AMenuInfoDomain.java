package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AMenuInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AMenuInfoDomain extends AMenuInfoModel {
    public AMenuWzInfoDomain getAmenuwzInfoDomain() {
        return amenuwzInfoDomain;
    }

    public void setAmenuwzInfoDomain(AMenuWzInfoDomain amenuwzInfoDomain) {
        this.amenuwzInfoDomain = amenuwzInfoDomain;
    }

    private AMenuWzInfoDomain amenuwzInfoDomain;
}
