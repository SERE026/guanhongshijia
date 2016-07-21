package com.wckj.gfsj.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.wckj.gfsj.R;

/**
 * Created by jinlei on 2016/7/21.
 * 更多
 */
public class MainMoreActivity extends Activity{

    private GridView gv_more_recommend;
    private TextView tv_go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_shopping);
        initView();
    }

    private void initView() {
        gv_more_recommend = (GridView) findViewById(R.id.gv_more_recommend);
        tv_go_back = (TextView) findViewById(R.id.tv_go_back);


    }

}
