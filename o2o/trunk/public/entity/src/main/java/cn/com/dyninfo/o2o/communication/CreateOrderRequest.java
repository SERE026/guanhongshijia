package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.CartItem;

import java.util.List;

/**
 * 创建订单请求类，在购物车点击去结算时使用
 * request URL: https://serverurl/app/addFavorites
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
}
