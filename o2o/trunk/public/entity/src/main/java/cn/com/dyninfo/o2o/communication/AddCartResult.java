package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;

/**
 * Created by Administrator on 2016/7/29.
 */
public class AddCartResult extends BaseResult {
    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "AddCartResult{" +
                "cartId='" + cartId + '\'' +
                '}';
    }
}
