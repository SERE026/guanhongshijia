package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wckj.gfsj.Activity.MainMoreActivity;
import com.wckj.gfsj.R;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends Fragment implements View.OnClickListener {
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_main_classification, null);
//        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
//        tv_msg.setText("cccc");
         view.findViewById(R.id.btn_chinese_furniture).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_chinese_furniture:
                Intent intent = new Intent(view.getContext(), MainMoreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
