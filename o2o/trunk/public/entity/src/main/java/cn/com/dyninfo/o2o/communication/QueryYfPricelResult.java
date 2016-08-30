package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseResult;
import cn.com.dyninfo.o2o.entity.Personal;

/**
 * Created by Administrator on 2016/7/25.
 */
public class QueryYfPricelResult extends BaseResult {

    private Double yfPrice = 0.0;

    public Double getYfPrice() {
        return yfPrice;
    }

    public void setYfPrice(Double yfPrice) {
        this.yfPrice = yfPrice;
    }

    @Override
    public String toString() {
        return "QueryYfPricelResult{" +
                "yfPrice=" + yfPrice +
                '}';
    }
}
