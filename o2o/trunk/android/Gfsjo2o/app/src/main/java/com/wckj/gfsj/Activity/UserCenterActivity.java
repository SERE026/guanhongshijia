package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/7/24.
 */
public class UserCenterActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;
    private Button mBtnMyOrder, mBtnMyBrokerage, mBtnUserInfo, mBtnMyFollow, mBtnSetPwd, mBtnExit;

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
        view = inflater.inflate(R.layout.activity_user_center, null);
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

    private void initView() {
        mBtnMyOrder = (Button) view.findViewById(R.id.btn_my_order);
        mBtnMyBrokerage = (Button) view.findViewById(R.id.btn_brokerage);
        mBtnUserInfo = (Button) view.findViewById(R.id.btn_user_info);
        mBtnMyFollow = (Button) view.findViewById(R.id.btn_my_follow);
        mBtnSetPwd = (Button) view.findViewById(R.id.btn_set_pwd);
        mBtnExit = (Button) view.findViewById(R.id.btn_exit);

        mBtnMyOrder.setOnClickListener(this);
        mBtnMyBrokerage.setOnClickListener(this);
        mBtnUserInfo.setOnClickListener(this);
        mBtnMyFollow.setOnClickListener(this);
        mBtnSetPwd.setOnClickListener(this);
        mBtnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_my_order:
                break;
            case R.id.btn_brokerage:
                break;
            case R.id.btn_user_info:
                break;
            case R.id.btn_my_follow:
                break;
            case R.id.btn_set_pwd:
                Intent intent = new Intent(view.getContext(), SetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_exit:
                break;
        }
    }
}
