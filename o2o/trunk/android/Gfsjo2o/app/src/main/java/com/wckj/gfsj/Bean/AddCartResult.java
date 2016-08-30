package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseResult;
import com.wckj.gfsj.Bean.entity.CartItem;

/**
 * Created by Administrator on 2016/7/29.
 */
public class AddCartResult extends BaseResult {
    private CartItem cartItem;

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "AddCartResult{" +
                "cartItem=" + cartItem +
                '}';
    }
}
