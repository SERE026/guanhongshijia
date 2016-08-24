package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.AddressMember;
import cn.com.dyninfo.o2o.entity.CartItem;

import java.util.List;

/**
 * 支付宝支付成功后确认
 * request URL: https://serverurl/app/order/confirm
 * request method: post
 */
public class ConfirmOrderRequest extends BaseRequest {


    private  String payStatus;//支付时候成功 0成功 1失败
    //交易ID
    private String tradeNo;

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "ConfirmOrderRequest{" +
                "payStatus='" + payStatus + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
