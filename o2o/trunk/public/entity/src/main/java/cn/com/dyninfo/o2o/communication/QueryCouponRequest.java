package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageRequest;

/**
 * 优惠券查询请求类
 * request URL: https://serverurl/app/user/coupon
 * request method: post
 */
public class QueryCouponRequest extends PageRequest {

    //状态：0-全部；1-未使用；2-已使用；3-已过期
    private int status;
    //优惠券类型：0-全部；1-代金券；2-折扣券
    private int type;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "QueryCouponRequest{" +
                "status=" + status +
                ", type=" + type +
                '}';
    }
}
