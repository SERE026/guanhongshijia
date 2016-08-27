package com.wckj.gfsj.Bean;

import com.wckj.gfsj.Bean.entity.Coupon;

/**
 * Created by rayco on 16/8/26.
 */
public class PayMethod {
    private int id;
    private String name;
    private String toast;
    private boolean cancelCheck;
    private Coupon coupon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isCancelCheck() {
        return cancelCheck;
    }

    public void setCancelCheck(boolean cancelCheck) {
        this.cancelCheck = cancelCheck;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
