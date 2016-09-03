package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.OwerToastShow;

/**
 * Created by rayco on 2016/7/24.
 */
public class InputLockPwdActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private EditText mEtLockPwd;
    private Button mBtnConfirm;

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
        view = inflater.inflate(R.layout.activity_input_lock_pwd, null);
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
        mEtLockPwd = (EditText) view.findViewById(R.id.et_lock_pwd);
        mBtnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        mBtnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_confirm:
                String pwd = mEtLockPwd.getText().toString().trim();
                if (pwd.isEmpty()) {
                    OwerToastShow.show("请输入锁定密码");
                    return;
                }
                SharedPreferences sp = getSharedPreferences("ghsj", MODE_PRIVATE);
                String savedPwd = sp.getString("lockPwd", "");
                if (pwd.equals(savedPwd)) {
                    Intent intent = new Intent(this, UserCenterActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    OwerToastShow.show("密码错误");
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
