package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.BaseRequest;
import cn.com.dyninfo.o2o.communication.common.PageRequest;

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
