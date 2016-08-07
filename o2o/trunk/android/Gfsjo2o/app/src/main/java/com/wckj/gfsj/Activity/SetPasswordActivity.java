package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.SetLockPasswordRequest;
import com.wckj.gfsj.Bean.SetLockPasswordResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/22.
 */
public class SetPasswordActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;
    private Button mBtnSet, mBtnModify, mBtnFind;
    private RelativeLayout mRlSetPwd, mRlModifyPwd, mRlFindPwd;
    private Button mBtnSetComplete, mBtnModifyComplete;

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

//        mBtnFind = (Button) view.findViewById(R.id.btn_find);
//        mBtnFind.setOnClickListener(this);

        mRlSetPwd = (RelativeLayout) view.findViewById(R.id.rl_set_pwd);
        mRlModifyPwd = (RelativeLayout) view.findViewById(R.id.rl_modify_pwd);
//        mRlFindPwd = (RelativeLayout) view.findViewById(R.id.rl_find_pwd);

        mBtnSetComplete = (Button) view.findViewById(R.id.btn_set_complete);
        mBtnSetComplete.setOnClickListener(this);
        mBtnModifyComplete = (Button) view.findViewById(R.id.btn_modify_complete);
        mBtnModifyComplete.setOnClickListener(this);
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
//                mRlFindPwd.setVisibility(View.GONE);
                break;
            case R.id.btn_modify:
                mRlSetPwd.setVisibility(View.GONE);
                mRlModifyPwd.setVisibility(View.VISIBLE);
//                mRlFindPwd.setVisibility(View.GONE);
                break;
//            case R.id.btn_find:
//                mRlSetPwd.setVisibility(View.GONE);
//                mRlModifyPwd.setVisibility(View.GONE);
//                mRlFindPwd.setVisibility(View.VISIBLE);
//                break;
            case R.id.btn_set_complete:
//                setLockPwd("123456");
                break;
            case R.id.btn_modify_complete:
                break;
        }
    }

    /**
     * 设置锁定密码
     * @param password 锁定密码
     */
    private void setLockPwd(String password) {
        SetLockPasswordRequest request = new SetLockPasswordRequest();
        request.setPassword(password);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.SET_PWD_LOCK_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                SetLockPasswordResult json = JSON.parseObject(response, SetLockPasswordResult.class);
                LogUtil.i(response + "");
            }
        });
    }
}
