package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.MoreRecommendAdapter;
import com.wckj.gfsj.Bean.Commodity_level_two;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * Created by jinlei on 2016/7/21.
 * 更多一级商品列表
 */
public class MainMoreActivity extends BaseNewActivity implements View.OnClickListener {

    private GridView gv_more_recommend;
    private TextView tv_go_back;
    private ArrayList<Commodity_level_two> mList;
    private MoreRecommendAdapter mRecommendMoreAdapter;
    private View view;


    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_more, null);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_recommend_more_gridview, null);
        initView();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new Commodity_level_two());
        }
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    private void initView() {
        gv_more_recommend = (GridView) view.findViewById(R.id.gv_more_recommend);


        mRecommendMoreAdapter = new MoreRecommendAdapter(this, mList);
        gv_more_recommend.setAdapter(mRecommendMoreAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

}
