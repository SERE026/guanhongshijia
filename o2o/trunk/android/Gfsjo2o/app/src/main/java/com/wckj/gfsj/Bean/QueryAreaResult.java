package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseResult;
import com.wckj.gfsj.Bean.entity.Area;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QueryAreaResult  extends BaseResult {
     private List<Area> areaList;

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @Override
    public String toString() {
        return "QueryAreaResult{" +
                "areaList=" + areaList +
                '}';
    }
}
