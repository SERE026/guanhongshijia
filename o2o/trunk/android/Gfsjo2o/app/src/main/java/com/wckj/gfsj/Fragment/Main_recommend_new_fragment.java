package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Adapter.RecommendAdapter;
import com.wckj.gfsj.Bean.RecommendGoodsRequest;
import com.wckj.gfsj.Bean.RecommendGoodsResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import okhttp3.Call;

/**
 * 推荐更多商品
 */
public class Main_recommend_new_fragment extends BaseNewFragment{

    private View view;
    private GridView gv_recommend;
    private RecommendAdapter mRecommendAdapter;
    private RecommendGoodsResult json;


    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.fragment_main_recommend, null);
        initView();
        setListener();
        return view;
    }

    @Override
    protected void load() {
        getGoodsRecommend();
    }

    @Override
    protected void refreshOrLoadView() {

    }

    private void setListener() {
        gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent  =new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        gv_recommend = (GridView) view.findViewById(R.id.gv_recommend);

        mRecommendAdapter = new RecommendAdapter(view.getContext(), json.getNewList());
        gv_recommend.setAdapter(mRecommendAdapter);
    }
    //推荐
    private void getGoodsRecommend(){
        RecommendGoodsRequest request = new RecommendGoodsRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.NEW_RECOMMEND_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 json =  JSON.parseObject(response, RecommendGoodsResult.class);
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });


    }

}
