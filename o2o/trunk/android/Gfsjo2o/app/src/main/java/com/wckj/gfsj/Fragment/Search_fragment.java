package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.SearchRequest;
import com.wckj.gfsj.Bean.SearchResult;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 * 搜索
 */
public class Search_fragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);

        search("红木");

        return view;
    }

    private void search(String keyword) {
        SearchRequest request = new SearchRequest();
        request.setKeyword(keyword);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_SEARCH_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onSuccess(String response) {
                SearchResult json = JSON.parseObject(response, SearchResult.class);
            }
        });
    }
}
