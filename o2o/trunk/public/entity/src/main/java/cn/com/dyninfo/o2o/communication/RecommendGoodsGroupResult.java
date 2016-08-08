package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class RecommendGoodsGroupResult extends PageResult {

    //团购列表
    private List<Recommend> groupList;

    public List<Recommend> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Recommend> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "RecommendGoodsGroupResult{" +
                "groupList=" + groupList +
                '}';
    }
}
