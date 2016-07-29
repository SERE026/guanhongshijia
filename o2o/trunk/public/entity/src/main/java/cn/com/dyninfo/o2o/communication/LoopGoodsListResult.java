package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.entity.GoodsDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class LoopGoodsListResult extends BaseResult {

    private List<GoodsDetail> goodsDetailList;

    public List<GoodsDetail> getGoodsDetailList() {
        return goodsDetailList;
    }

    public void setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
        this.goodsDetailList = goodsDetailList;
    }
}
