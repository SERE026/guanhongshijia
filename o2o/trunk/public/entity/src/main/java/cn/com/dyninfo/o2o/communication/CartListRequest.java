package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;

/**
 * 购物车列表请求类
 * request URL: https://serverurl/app/cartList
 * request method: post
 */
public class CartListRequest extends BaseRequest {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
