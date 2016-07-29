package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.GoodsDetail;

/**
 * 商品详情请求类
 * request URL: https://serverurl/app/goodsDetail
 * request method: post
 */
public class GoodsDetailRequest extends BaseRequest {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
