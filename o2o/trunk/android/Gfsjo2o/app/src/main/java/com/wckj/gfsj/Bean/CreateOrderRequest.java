package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;
import com.wckj.gfsj.Bean.entity.CartItem;

import java.util.List;


/**
 * 创建订单请求类，在购物车点击去结算时使用
 * request URL: https://serverurl/app/order/create
 * request method: post
 */
public class CreateOrderRequest extends BaseRequest {

    private List<CartItem> cartItemList;

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
                '}';
    }
}
