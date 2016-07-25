package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.GoodsDetail;

/**
 * 商品详情请求类
 * request URL: https://serverurl/app/goodsDetail
 * request method: post
 */
public class GoodsDetailRequest extends BaseRequest {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
