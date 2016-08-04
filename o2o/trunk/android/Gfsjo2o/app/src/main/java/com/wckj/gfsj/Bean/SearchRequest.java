package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageRequest;

/**
 * 搜索请求类
 * request URL: https://serverurl/app/goods/search
 * request method: post
 */
public class SearchRequest extends PageRequest {

    //搜索关键字
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
