package cn.com.dyninfo.o2o.entity.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/25.
 */
public class BaseEntity implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
