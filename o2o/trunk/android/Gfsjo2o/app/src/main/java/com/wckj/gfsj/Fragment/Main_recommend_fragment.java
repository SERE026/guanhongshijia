package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Adapter.RecommendAdapter;
import com.wckj.gfsj.Bean.Commodity_level_one;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * 推荐更多商品
 */
public class Main_recommend_fragment extends Fragment{

    private View view;
    private GridView gv_recommend;
    private ArrayList<Commodity_level_one> mShopping;
    private RecommendAdapter mRecommendAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_recommend, null);
        initView();
        setListener();
        return view;
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
         mShopping = new ArrayList<>();
        for (int i = 0; i <16 ; i++) {
            mShopping.add(new Commodity_level_one());
        }
        mRecommendAdapter = new RecommendAdapter(view.getContext(), mShopping);
        gv_recommend.setAdapter(mRecommendAdapter);
    }
}
