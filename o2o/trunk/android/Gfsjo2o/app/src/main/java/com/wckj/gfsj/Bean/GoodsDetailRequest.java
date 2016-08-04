package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;

/**
 * 商品详情请求类
 * request URL: https://serverurl/app/goods/detail
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

    @Override
    public String toString() {
        return "GoodsDetailRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
