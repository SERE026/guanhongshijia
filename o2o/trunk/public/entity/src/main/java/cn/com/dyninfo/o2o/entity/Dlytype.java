package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * 快递实体
 * Created by dyninfo on 2016/8/30.
 */
public class Dlytype  extends BaseEntity {
    private String dlyName;//快递名称

    public String getDlyName() {
        return dlyName;
    }

    public void setDlyName(String dlyName) {
        this.dlyName = dlyName;
    }

    @Override
    public String toString() {
        return "Dlytype{" +
                "dlyName='" + dlyName + '\'' +
                '}';
    }
}
