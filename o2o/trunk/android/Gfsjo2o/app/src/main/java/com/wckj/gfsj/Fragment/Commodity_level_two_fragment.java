package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wckj.gfsj.R;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Commodity_level_two_fragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_main, null);
        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_msg.setText("列表");
        return view;
    }
}
