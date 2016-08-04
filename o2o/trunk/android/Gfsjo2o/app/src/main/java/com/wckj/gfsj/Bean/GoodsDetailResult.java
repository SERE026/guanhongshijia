package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.entity.GoodsDetail;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsDetailResult {

    private GoodsDetail detail;

    public GoodsDetail getDetail() {
        return detail;
    }

    public void setDetail(GoodsDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "GoodsDetailResult{" +
                "detail=" + detail +
                '}';
    }
}
