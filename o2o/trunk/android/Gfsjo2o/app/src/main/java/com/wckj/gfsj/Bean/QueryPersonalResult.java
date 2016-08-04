package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseResult;
import com.wckj.gfsj.Bean.entity.Personal;

/**
 * Created by Administrator on 2016/7/25.
 */
public class QueryPersonalResult extends BaseResult {

    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "QueryPersonalResult{" +
                "personal=" + personal +
                '}';
    }
}
