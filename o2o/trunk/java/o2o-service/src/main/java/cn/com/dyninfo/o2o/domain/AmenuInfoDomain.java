package cn.com.dyninfo.o2o.domain;

import cn.com.dyninfo.o2o.model.AMenuInfoModel;

/**
 * Created by dyninfo on 2016/7/19.
 */
public class AmenuInfoDomain extends AMenuInfoModel {
    public AmenuwzInfoDomain getAmenuwzInfoDomain() {
        return amenuwzInfoDomain;
    }

    public void setAmenuwzInfoDomain(AmenuwzInfoDomain amenuwzInfoDomain) {
        this.amenuwzInfoDomain = amenuwzInfoDomain;
    }

    private AmenuwzInfoDomain amenuwzInfoDomain;
}
