package cn.com.dyninfo.o2o.communication.common;

import java.io.Serializable;

/**
 * 启动请求类
 */
public class BaseRequest implements Serializable {

    //登录成功后后台返回的token，每次请求时都要赋值，为空表示未登录
    private String token;

    private int pageSize = 10;

    private int pageNo = 1;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
