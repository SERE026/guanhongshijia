package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.dalong.francyconverflow.FancyCoverFlow;
import com.wckj.gfsj.Activity.CommoditydetailsActivity;
import com.wckj.gfsj.Adapter.MyFancyCoverFlowAdapter;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Main_main_fragment extends Fragment{
    private FancyCoverFlow mfancyCoverFlow;
    private View view;
    private ArrayList<Commodity_level_details> mList;
    private MyFancyCoverFlowAdapter mMyFancyCoverFlowAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_main_main, null);
        initScroView();
        return view;
    }
    private void  initScroView() {
        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mList.add( new Commodity_level_details());
        }
        mfancyCoverFlow = (FancyCoverFlow) view.findViewById(R.id.fancyCoverFlow);
        mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(view.getContext(), mList);
        mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
         mMyFancyCoverFlowAdapter.notifyDataSetChanged();
        mfancyCoverFlow.setUnselectedAlpha(0.5f);//通明度
        mfancyCoverFlow.setUnselectedSaturation(0.5f);//设置选中的饱和度
        mfancyCoverFlow.setUnselectedScale(0.5f);//设置选中的规模
        mfancyCoverFlow.setSpacing(0);//设置间距
        mfancyCoverFlow.setMaxRotation(0);//设置最大旋转
        mfancyCoverFlow.setScaleDownGravity(0.5f);
        mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
      int num = Integer.MAX_VALUE / 2 % mList.size();
      int selectPosition = Integer.MAX_VALUE / 2 - num;
      mfancyCoverFlow.setSelection(1);
        mfancyCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CommoditydetailsActivity.class);
                startActivity(intent);
            }
        });

    }
    }
