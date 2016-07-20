package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wckj.gfsj.R;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends Fragment{
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_main_classification, null);
//        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
//        tv_msg.setText("cccc");
        Button btn = (Button) view.findViewById(R.id.btn_chinese_furniture);

        return view;
    }
}
