package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;
import com.wckj.gfsj.Bean.entity.AddressMember;
import com.wckj.gfsj.Bean.entity.CartItem;

import java.util.List;

/**
 * 创建订单请求类，在购物车点击去结算时使用
 * request URL: https://serverurl/app/order/create
 * request method: post
 */
public class CreateOrderRequest extends BaseRequest {

    private List<CartItem> cartItemList;

    private AddressMember addressMember;

    private String coupons;

    private  String dlyType;

    private  String accountStr;

    private  String playType;

    private String shop;

    private String dlytypeId;//快递ID

    public String getDlytypeId() {
        return dlytypeId;
    }

    public void setDlytypeId(String dlytypeId) {
        this.dlytypeId = dlytypeId;
    }


    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }
    public String getDlyType() {
        return dlyType;
    }

    public void setDlyType(String dlyType) {
        this.dlyType = dlyType;
    }

    public String getAccountStr() {
        return accountStr;
    }

    public void setAccountStr(String accountStr) {
        this.accountStr = accountStr;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public AddressMember getAddressMember() {
        return addressMember;
    }

    public void setAddressMember(AddressMember addressMember) {
        this.addressMember = addressMember;
    }


    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "cartItemList=" + cartItemList +
                ", addressMember=" + addressMember +
                ", coupons='" + coupons + '\'' +
                ", dlyType='" + dlyType + '\'' +
                ", accountStr='" + accountStr + '\'' +
                ", playType='" + playType + '\'' +
                ", shop='" + shop + '\'' +
                '}';
    }
}
