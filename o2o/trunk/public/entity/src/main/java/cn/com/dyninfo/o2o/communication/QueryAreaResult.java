package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.AgencyFeeItem;
import cn.com.dyninfo.o2o.entity.Area;

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
