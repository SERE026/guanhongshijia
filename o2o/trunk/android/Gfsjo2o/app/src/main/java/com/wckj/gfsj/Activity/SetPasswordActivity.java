package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.FindPasswordRequest;
import com.wckj.gfsj.Bean.FindPasswordResult;
import com.wckj.gfsj.Bean.SetLockPasswordRequest;
import com.wckj.gfsj.Bean.SetLockPasswordResult;
import com.wckj.gfsj.Bean.SmsRequest;
import com.wckj.gfsj.Bean.SmsResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;
import com.wckj.gfsj.Utils.Validator;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/22.
 */
public class SetPasswordActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private Button mBtnSet, mBtnFind;
    private RelativeLayout mRlSetPwd, mRlFindPwd;
    private Button mBtnSetComplete;

    private TextView mEtPhoneNum, mEtCode, mEtPwd, mEtConfirmPwd;
    private Button mBtnSend, mBtnGetAgain, mBtnFindComplete;

    private EditText mEtSetPwd, mEtSetConfirmPwd;

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

        mBtnFind = (Button) view.findViewById(R.id.btn_find);
        mBtnFind.setOnClickListener(this);

        mRlSetPwd = (RelativeLayout) view.findViewById(R.id.rl_set_pwd);
        mRlFindPwd = (RelativeLayout) view.findViewById(R.id.rl_find_pwd);

        mBtnSetComplete = (Button) view.findViewById(R.id.btn_set_complete);
        mBtnSetComplete.setOnClickListener(this);
        mBtnFindComplete = (Button) view.findViewById(R.id.btn_find_complete);
        mBtnFindComplete.setOnClickListener(this);

        mEtSetPwd = (EditText) view.findViewById(R.id.et_set_pwd);
        mEtSetConfirmPwd = (EditText) view.findViewById(R.id.et_set_confirm_pwd);

        mEtPhoneNum = (TextView) view.findViewById(R.id.et_phone_num);
        mEtCode = (TextView) view.findViewById(R.id.et_code);
        mEtPwd = (TextView) view.findViewById(R.id.et_pwd);
        mEtConfirmPwd = (TextView) view.findViewById(R.id.et_confirm_pwd);

        mBtnSend = (Button) view.findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        mBtnGetAgain = (Button) view.findViewById(R.id.btn_get_again);
        mBtnGetAgain.setOnClickListener(this);
        mBtnFindComplete = (Button) view.findViewById(R.id.btn_find_complete);
        mBtnFindComplete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_set:
                mRlSetPwd.setVisibility(View.VISIBLE);
                mRlFindPwd.setVisibility(View.GONE);
                break;
            case R.id.btn_find:
                mRlSetPwd.setVisibility(View.GONE);
                mRlFindPwd.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_set_complete:
                String setPwd = mEtSetPwd.getText().toString().trim();
                String setConfirmPwd  = mEtSetConfirmPwd.getText().toString().trim();
                if (setPwd.isEmpty()) {
                    OwerToastShow.show("请输入密码");
                    return;
                }
                if (!Validator.isPassword(setPwd)) {
                    OwerToastShow.show("密码格式错误");
                    return;
                }
                if (setConfirmPwd.isEmpty()) {
                    OwerToastShow.show("请确认密码");
                    return;
                }
                if (!setPwd.equals(setConfirmPwd)) {
                    OwerToastShow.show("两次输入密码不一致");
                    return;
                }
                setLockPwd(setPwd);
                break;
            case R.id.btn_send:
                String phoneNum = mEtPhoneNum.getText().toString().trim();
                if (phoneNum.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
                    return;
                }
                if (!Validator.isMobile(phoneNum)) {
                    OwerToastShow.show("手机号格式错误");
                    return;
                }
                sendSms(phoneNum, 2);
                break;
            case R.id.btn_get_again:
                String phoneNum2 = mEtPhoneNum.getText().toString().trim();
                if (phoneNum2.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
                    return;
                }
                if (!Validator.isMobile(phoneNum2)) {
                    OwerToastShow.show("手机号格式错误");
                    return;
                }
                sendSms(phoneNum2, 2);
                break;
            case R.id.btn_find_complete:
                String phoneNum3 = mEtPhoneNum.getText().toString().trim();
                if (phoneNum3.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
                    return;
                }
                if (!Validator.isMobile(phoneNum3)) {
                    OwerToastShow.show("手机号格式错误");
                    return;
                }
                String validateCode = mEtCode.getText().toString().trim();
                if (validateCode.isEmpty()) {
                    OwerToastShow.show("请输入验证码");
                    return;
                }
                String password = mEtPwd.getText().toString().trim();
                String confirmPwd  = mEtConfirmPwd.getText().toString().trim();
                if (password.isEmpty()) {
                    OwerToastShow.show("请输入密码");
                    return;
                }
                if (!Validator.isPassword(password)) {
                    OwerToastShow.show("密码格式错误");
                    return;
                }
                if (confirmPwd.isEmpty()) {
                    OwerToastShow.show("请确认密码");
                    return;
                }
                if (!password.equals(confirmPwd)) {
                    OwerToastShow.show("两次输入密码不一致");
                    return;
                }
                findPassword(phoneNum3, validateCode, password);
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
                SetLockPasswordResult result = JSON.parseObject(response, SetLockPasswordResult.class);
                LogUtil.i(response);
                if (result.getResultCode() == 0) {
                    OwerToastShow.show("设置成功");
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }

    /**
     * 找回登陆密码/找回锁定密码
     * @param mobileNo     手机号码
     * @param validateCode 校验码
     * @param newPassword  新密码
     */
    private void findPassword(String mobileNo, String validateCode, String newPassword) {
        FindPasswordRequest request = new FindPasswordRequest();
        request.setMobileNo(mobileNo);
        request.setValidateCode(validateCode);
        request.setNewPassword(newPassword);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FIND_PWD_LOCK_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                FindPasswordResult result = JSON.parseObject(response, FindPasswordResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    OwerToastShow.show("密码修改成功");
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }

    /**
     * 发送短信
     * @param mobileNo 接收短信的手机号码
     * @param type     请求类型(1-找回登录密码；2-找回锁定密码)
     */
    private void sendSms(String mobileNo, int type) {
        SmsRequest request = new SmsRequest();
        request.setMobileNo(mobileNo);
        request.setType(type);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.SMS_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                SmsResult result = JSON.parseObject(response, SmsResult.class);
                LogUtil.i(response);
                if (result.getResultCode() == 0) {
                    OwerToastShow.show("短信发送成功");
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
