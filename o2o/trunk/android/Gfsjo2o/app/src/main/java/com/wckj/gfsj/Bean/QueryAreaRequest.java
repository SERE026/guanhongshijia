package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.BaseRequest;

/**
 * 市、区查询请求
 * request URL: https://serverurl/app/user/queryArea
 * request method: post
 */
public class QueryAreaRequest extends BaseRequest {
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "QueryAreaRequest{" +
                "parentId='" + parentId + '\'' +
                '}';
    }
}
