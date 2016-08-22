package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.CartItem;

import java.util.List;

/**
 * 更改订单请求类，
 * request URL: https://serverurl/app/order/update
 * request method: post
 */
public class UpdateOrderRequest extends BaseRequest {

    private String orderId;//订单ID
    private int orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
