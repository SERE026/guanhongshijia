package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Coupon;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QueryCouponResult extends PageResult {

    private List<Coupon> couponList;

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    @Override
    public String toString() {
        return "QueryCouponResult{" +
                "couponList=" + couponList +
                '}';
    }
}
