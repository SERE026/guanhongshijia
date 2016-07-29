package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Coupon;

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
}
