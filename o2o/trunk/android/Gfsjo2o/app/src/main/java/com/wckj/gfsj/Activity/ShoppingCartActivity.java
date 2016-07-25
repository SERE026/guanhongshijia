package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wckj.gfsj.R;

import de.greenrobot.event.EventBus;

/**
 * 购物车页面
 */
public class ShoppingCartActivity extends BaseNewActivity implements View.OnClickListener {
    private TextView tv_time;
    @Override
    protected void init() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_go_back, null);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        titleView. findViewById(R.id.tv_content_desc).setVisibility(View.GONE);
        tv_time = (TextView) titleView.findViewById(R.id.tv_time);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        return null;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {

    }
}
