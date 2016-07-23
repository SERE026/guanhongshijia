package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/7/22.
 */
public class SetPasswordActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;
    private Button mBtnSet, mBtnModify, mBtnFind;
    private RelativeLayout mRlSetPwd, mRlModifyPwd;


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
        view = inflater.inflate(R.layout.activity_set_password, null);
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

        mBtnSet = (Button) view.findViewById(R.id.btn_set);
        mBtnSet.setOnClickListener(this);

        mBtnModify = (Button) view.findViewById(R.id.btn_modify);
        mBtnModify.setOnClickListener(this);

        mBtnFind = (Button) view.findViewById(R.id.btn_find);
        mBtnFind.setOnClickListener(this);

        mRlSetPwd = (RelativeLayout) view.findViewById(R.id.rl_set_pwd);
        mRlModifyPwd = (RelativeLayout) view.findViewById(R.id.rl_modify_pwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_set:
                mRlSetPwd.setVisibility(View.VISIBLE);
                mRlModifyPwd.setVisibility(View.GONE);
                break;
            case R.id.btn_modify:
                mRlSetPwd.setVisibility(View.GONE);
                mRlModifyPwd.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_find:
                break;
        }
    }
}
