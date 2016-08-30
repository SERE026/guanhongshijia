package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseResult;
import com.wckj.gfsj.Bean.entity.Coupon;
import com.wckj.gfsj.Bean.entity.Dlytype;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class SubmitOrderResult extends BaseResult {

    //可使用的优惠券列表
    private List<Coupon> couponList;
    //可使用的快递列表
    private List<Dlytype> dlytypeList;

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<Dlytype> getDlytypeList() {
        return dlytypeList;
    }

    public void setDlytypeList(List<Dlytype> dlytypeList) {
        this.dlytypeList = dlytypeList;
    }

    @Override
    public String toString() {
        return "SubmitOrderResult{" +
                "couponList=" + couponList +
                ", dlytypeList=" + dlytypeList +
                '}';
    }
}
