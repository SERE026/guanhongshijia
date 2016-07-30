package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.communication.common.PageRequest;

/**
 * 评价订单请求类
 * request URL: https://serverurl/app/order/eval
 * request method: post
 */
public class EvalOrderRequest extends PageRequest {

    //订单ID
    private String orderId;
    //商品符合度星星数量从1-5
    private int sameStar;
    //物流速度星星数量，从1-5
    private int speedStar;
    //配送员服务态度星星数量，从1-5
    private int attitudeStar;
    //订单状态：-1——全部；0——待付款；1——待发货；2——待收货，根据当前所在tab页填入，用于返回刷新后的订单列表
    private int orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getSameStar() {
        return sameStar;
    }

    public void setSameStar(int sameStar) {
        this.sameStar = sameStar;
    }

    public int getSpeedStar() {
        return speedStar;
    }

    public void setSpeedStar(int speedStar) {
        this.speedStar = speedStar;
    }

    public int getAttitudeStar() {
        return attitudeStar;
    }

    public void setAttitudeStar(int attitudeStar) {
        this.attitudeStar = attitudeStar;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "EvalOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", sameStar=" + sameStar +
                ", speedStar=" + speedStar +
                ", attitudeStar=" + attitudeStar +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
