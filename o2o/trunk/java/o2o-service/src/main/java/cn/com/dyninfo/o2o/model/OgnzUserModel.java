package cn.com.dyninfo.o2o.model;

import java.io.Serializable;

public class OgnzUserModel implements Serializable {
    private Integer userId;

    private Integer ognzId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOgnzId() {
        return ognzId;
    }

    public void setOgnzId(Integer ognzId) {
        this.ognzId = ognzId;
    }
}