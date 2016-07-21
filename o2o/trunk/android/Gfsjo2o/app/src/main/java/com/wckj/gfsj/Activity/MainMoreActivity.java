package com.wckj.gfsj.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.MoreRecommendAdapter;
import com.wckj.gfsj.Bean.CommodityCategory;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * Created by jinlei on 2016/7/21.
 * 更多
 */
public class MainMoreActivity extends Activity implements View.OnClickListener {

    private GridView gv_more_recommend;
    private TextView tv_go_back;
    private ArrayList<CommodityCategory> mList;
    private MoreRecommendAdapter mRecommendMoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_shopping);
        initView();
    }

    private void initView() {
        gv_more_recommend = (GridView) findViewById(R.id.gv_more_recommend);
        findViewById(R.id.tv_go_back).setOnClickListener(this);
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new CommodityCategory());
        }
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
