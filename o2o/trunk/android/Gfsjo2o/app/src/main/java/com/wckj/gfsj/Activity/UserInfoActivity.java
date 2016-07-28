package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/7/25.
 */
public class UserInfoActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_set_password, null);
        titleView.findViewById(R.id.tv_go_back).setOnClickListener(this);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_user_info, null);
        initView();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    private void initView() {

    }
}
