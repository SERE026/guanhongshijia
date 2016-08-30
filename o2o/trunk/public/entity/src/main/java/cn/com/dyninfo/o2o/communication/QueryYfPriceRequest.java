package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.communication.common.BaseResult;

/**
 * 运费查询请求类
 * request URL: https://serverurl/app/order/queryYfPrice
 * request method: post
 */
public class QueryYfPriceRequest extends BaseRequest {
    private Double weight= 0.0;//商品总重量
    private String countyId;//城市ID
    private String dlytypeId;//选择的快递ID

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getDlytypeId() {
        return dlytypeId;
    }

    public void setDlytypeId(String dlytypeId) {
        this.dlytypeId = dlytypeId;
    }

    @Override
    public String toString() {
        return "QueryYfPriceRequest{" +
                "weight='" + weight + '\'' +
                ", countyId='" + countyId + '\'' +
                ", dlytypeId='" + dlytypeId + '\'' +
                '}';
    }
}
