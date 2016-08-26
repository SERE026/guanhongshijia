package com.wckj.gfsj.Bean;

import com.wckj.gfsj.Bean.entity.Coupon;

/**
 * Created by rayco on 16/8/26.
 */
public class PayMethod {
    private String name;
    private String toast;
    private Coupon coupon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToast() {
        return toast;
    }

    public void setToast(String toast) {
        this.toast = toast;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
