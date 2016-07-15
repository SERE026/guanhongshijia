package com.wckj.gfsj.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wckj.gfsj.R;

/**
 * 主页
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tv_main,tv_main_classification,tv_main_recommend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.rl_search).setOnClickListener(this);
        findViewById(R.id.tv_collect).setOnClickListener(this);
        findViewById(R.id.tv_shopping_cart).setOnClickListener(this);
        findViewById(R.id.tv_mine_center).setOnClickListener(this);
        tv_main = (TextView) findViewById(R.id.tv_main);
        tv_main_classification = (TextView) findViewById(R.id.tv_main_classification);
        tv_main_recommend = (TextView) findViewById(R.id.tv_main_recommend);
        tv_main.setOnClickListener(this);
        tv_main_recommend.setOnClickListener(this);

        View viewById = findViewById(R.id.stopVp_context);
    }

    private void initData() {
//        new
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_main://主页
                setMainColor(R.id.tv_main);
                break;
            case R.id.tv_main_classification://分类
                setMainColor(R.id.tv_main_classification);
                break;
            case R.id.tv_main_recommend://推荐
                setMainColor(R.id.tv_main_recommend);

                break;
            case R.id.rl_search:
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_shopping_cart:
                break;
            case R.id.tv_mine_center:
                break;
        }
    }

    /**
     * 设置首页分类三个颜色
     */
    private void setMainColor(int id){
        tv_main.setBackgroundResource(R.id.tv_main==id?R.drawable.icon_main_bg:0);
        tv_main_classification.setBackgroundResource(R.id.tv_main_classification==id?R.drawable.icon_main_bg:0);
        tv_main_recommend.setBackgroundResource(R.id.tv_main_recommend==id?R.drawable.icon_main_bg:0);
        tv_main.setTextColor(getResources().getColor(R.id.tv_main==id?R.color.colorfffffe:R.color.color767f8e));
        tv_main_classification.setTextColor(getResources().getColor(R.id.tv_main_classification==id?R.color.colorfffffe:R.color.color767f8e));
        tv_main_recommend.setTextColor(getResources().getColor(R.id.tv_main_recommend==id?R.color.colorfffffe:R.color.color767f8e));
    }
}