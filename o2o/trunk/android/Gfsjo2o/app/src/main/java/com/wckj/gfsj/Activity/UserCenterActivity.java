package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/7/24.
 */
public class UserCenterActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;
    private Button mBtnMyOrder, mBtnMyBrokerage, mBtnUserInfo, mBtnMyCoupon, mBtnSetPwd, mBtnExit;
    private EditText mEtBrokeragePwd;

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
        mBtnMyCoupon = (Button) view.findViewById(R.id.btn_my_coupon);
        mBtnSetPwd = (Button) view.findViewById(R.id.btn_set_pwd);
        mBtnExit = (Button) view.findViewById(R.id.btn_exit);

        mEtBrokeragePwd = (EditText) view.findViewById(R.id.et_brokerage_pwd);

        mBtnMyOrder.setOnClickListener(this);
        mBtnMyBrokerage.setOnClickListener(this);
        mBtnUserInfo.setOnClickListener(this);
        mBtnMyCoupon.setOnClickListener(this);
        mBtnSetPwd.setOnClickListener(this);
        mBtnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_go_back:
                setResult(100);
                finish();
                break;
            case R.id.btn_my_order:
                mEtBrokeragePwd.setVisibility(View.GONE);
                intent = new Intent(view.getContext(), MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_brokerage:
                mEtBrokeragePwd.setVisibility(View.VISIBLE);
                intent = new Intent(view.getContext(), MyBrokerageActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_user_info:
                mEtBrokeragePwd.setVisibility(View.GONE);
                intent = new Intent(view.getContext(), UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_coupon:
                mEtBrokeragePwd.setVisibility(View.GONE);
//                intent = new Intent(view.getContext(), OrderPayActivity.class);
//                intent = new Intent(view.getContext(), OrderEvaluateActivity.class);
                intent = new Intent(view.getContext(), CouponActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_set_pwd:
                mEtBrokeragePwd.setVisibility(View.GONE);
                intent = new Intent(view.getContext(), SetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_exit:
                break;
        }
    }
}
