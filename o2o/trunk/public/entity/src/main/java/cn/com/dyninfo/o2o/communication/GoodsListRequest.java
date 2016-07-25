package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.entity.Brand;
import cn.com.dyninfo.o2o.entity.GoodsSummary;

import java.util.List;

/**
 * 商品列表请求类
 * request URL: https://serverurl/app/goodsList
 * request method: post
 */
public class GoodsListRequest extends BaseRequest {

    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
