package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Adapter.RecommendAdapter;
import com.wckj.gfsj.Bean.RecommendGoodsGroupResult;
import com.wckj.gfsj.Bean.RecommendGoodsPromotionResult;
import com.wckj.gfsj.Bean.RecommendGoodsRequest;
import com.wckj.gfsj.Bean.RecommendNewGoodsResult;
import com.wckj.gfsj.Bean.entity.Recommend;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import java.util.List;

import okhttp3.Call;

/**
 * 推荐更多商品
 */
public class Main_recommend_new_fragment extends BaseNewFragment{

    private View view;
    private GridView gv_recommend;
    private RecommendAdapter mRecommendAdapter;
    private int typeId;
    private String  url;
    private RecommendNewGoodsResult result;
    private RecommendGoodsPromotionResult promotionResult;
    private RecommendGoodsGroupResult groupResult;
    private List<Recommend> mList;


    @Override
    protected void init() {
        Bundle arguments = getArguments();
        if(arguments!=null){
            typeId = arguments.getInt("recommendId");
        }
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
                Recommend recommend = (Recommend) parent.getItemAtPosition(position);
                intent.putExtra("id",recommend.getId());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        gv_recommend = (GridView) view.findViewById(R.id.gv_recommend);

        mRecommendAdapter = new RecommendAdapter(view.getContext(), mList);
        gv_recommend.setAdapter(mRecommendAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRecommendAdapter=null;
    }

    //推荐
    private void getGoodsRecommend(){
        final RecommendGoodsRequest request = new RecommendGoodsRequest();
        switch (typeId){
            case 0:
                url= GlobalUtils.NEW_RECOMMEND_URL;
            break;
            case 1:
                url= GlobalUtils.GROUP_RECOMMEND_URL;
                break;
            case 2:
                url= GlobalUtils.PROMOTION_RECOMMEND_URL;
                break;
        }
        HttpUtils.getInstance().asyncPost(request, url, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }
            @Override
            public void onSuccess(String response) {
                switch (typeId) {
                    case 0:
                        result =  JSON.parseObject(response, RecommendNewGoodsResult.class);
                        mList = result.getNewList();
                        break;
                    case 1:
                         groupResult =  JSON.parseObject(response, RecommendGoodsGroupResult.class);
                       mList =  groupResult.getGroupList();
                        break;
                    case 2:
                         promotionResult =  JSON.parseObject(response, RecommendGoodsPromotionResult.class);
                        mList =  promotionResult.getPromotionList();
                        break;
                }
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });


    }

}
