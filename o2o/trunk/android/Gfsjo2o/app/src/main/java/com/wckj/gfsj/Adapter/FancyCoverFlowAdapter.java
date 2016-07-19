package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.dalong.francyconverflow.FancyCoverFlowAdapter;
import com.wckj.gfsj.Bean.Shopping;

import java.util.List;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
 class MyFancyCoverFlowAdapter extends FancyCoverFlowAdapter {

    private Context mContext;

    public List<Shopping> list;

    public MyFancyCoverFlowAdapter(Context context, List<Shopping> list) {
        mContext = context;
        this.list = list;
    }
    @Override
    public View getCoverFlowItem(int position, View reusableView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
