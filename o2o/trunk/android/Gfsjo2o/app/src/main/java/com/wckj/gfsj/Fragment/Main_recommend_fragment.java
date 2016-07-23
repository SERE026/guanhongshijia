package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.wckj.gfsj.Adapter.RecommendAdapter;
import com.wckj.gfsj.Bean.Commodity_level_one;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 推荐
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
        return view;
    }

    private void initView() {
        gv_recommend = (GridView) view.findViewById(R.id.gv_recommend);
         mShopping = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mShopping.add(new Commodity_level_one());
        }
        mRecommendAdapter = new RecommendAdapter(view.getContext(), mShopping);
        gv_recommend.setAdapter(mRecommendAdapter);
    }
}
