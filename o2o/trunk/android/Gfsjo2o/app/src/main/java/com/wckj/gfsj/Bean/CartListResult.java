package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Cart;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CartListResult extends PageResult {

    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartListResult{" +
                "cart=" + cart +
                '}';
    }
}
