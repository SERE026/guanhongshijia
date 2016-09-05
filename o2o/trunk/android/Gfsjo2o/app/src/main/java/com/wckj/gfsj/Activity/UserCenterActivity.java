package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.LoginResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.Db.JsonDao;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.UuidUtils;

/**
 * Created by rayco on 2016/7/24.
 */
public class UserCenterActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private Button mBtnMyOrder, mBtnMyBrokerage, mBtnUserInfo, mBtnMyCoupon, mBtnSetPwd, mBtnExit;
    private TextView mTvUserName, mTvExit, mTvSetPwd;

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView =  inflater.inflate(R.layout.layout_public_title_main, null);
        mRlTitle = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        mRlTitle.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        TextView tv_content_desc = (TextView) mRlTitle.childView.findViewById(R.id.tv_content_desc);
        tv_content_desc.setVisibility(View.GONE);

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
        mTvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        mTvExit = (TextView) view.findViewById(R.id.tv_exit);
        mTvSetPwd = (TextView) view.findViewById(R.id.tv_set_pwd);

        mBtnMyOrder = (Button) view.findViewById(R.id.btn_my_order);
        mBtnMyBrokerage = (Button) view.findViewById(R.id.btn_brokerage);
        mBtnUserInfo = (Button) view.findViewById(R.id.btn_user_info);
        mBtnMyCoupon = (Button) view.findViewById(R.id.btn_my_coupon);
        mBtnSetPwd = (Button) view.findViewById(R.id.btn_set_pwd);
        mBtnExit = (Button) view.findViewById(R.id.btn_exit);

        mBtnMyOrder.setOnClickListener(this);
        mBtnMyBrokerage.setOnClickListener(this);
        mBtnUserInfo.setOnClickListener(this);
        mBtnMyCoupon.setOnClickListener(this);
        mBtnSetPwd.setOnClickListener(this);
        mBtnExit.setOnClickListener(this);

        if (AppApplication.loginResult.getLoginName() != null && !AppApplication.loginResult.getLoginName().isEmpty()) {
            mTvUserName.setText("Hi, " + AppApplication.loginResult.getLoginName());
            mTvExit.setText(AppApplication.loginResult.getLoginName());
            SharedPreferences sp = getSharedPreferences("ghsj", MODE_PRIVATE);
            boolean isSetLockPwd = sp.getBoolean("isSetLockPwd", false);
            if (isSetLockPwd) {
                mTvSetPwd.setText("已设置");
            } else {
                mTvSetPwd.setText("未设置");
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_my_order:
                intent = new Intent(view.getContext(), MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_brokerage:
                intent = new Intent(view.getContext(), MyBrokerageActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_user_info:
                intent = new Intent(view.getContext(), UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_coupon:
//                intent = new Intent(view.getContext(), OrderPayActivity.class);
//                intent = new Intent(view.getContext(), OrderEvaluateActivity.class);
                intent = new Intent(view.getContext(), CouponActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_set_pwd:
                intent = new Intent(view.getContext(), SetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_exit:
                JsonDao jsonDao =  new JsonDao();
                jsonDao.deleteJson(GlobalUtils.LOGIN_URL);
                AppApplication.loginResult = new LoginResult();
                AppApplication.loginResult.setDeviceId(UuidUtils.getUuid());
                finish();
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
