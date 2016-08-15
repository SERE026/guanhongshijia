package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class RecommendNewGoodsResult extends PageResult {

    //新品推荐列表
    private List<Recommend> newList;

    private  String image="";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Recommend> getNewList() {
        return newList;
    }

    public void setNewList(List<Recommend> newList) {
        this.newList = newList;
    }


    @Override
    public String toString() {
        return "RecommendGoodsResult{" +
                "newList=" + newList +
                '}';
    }
}
