package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.FindPasswordRequest;
import com.wckj.gfsj.Bean.FindPasswordResult;
import com.wckj.gfsj.Bean.SmsRequest;
import com.wckj.gfsj.Bean.SmsResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/30.
 */
public class FindPasswordActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_go_back;
    private View view;

    private TextView mEtPhoneNum, mEtCode, mEtPwd, mEtConfirmPwd;
    private Button mBtnSend, mBtnGetAgain, mBtnComplete;

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
        view = inflater.inflate(R.layout.activity_find_password, null);
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
            case R.id.btn_send:
                String phoneNum = mEtPhoneNum.getText().toString().trim();
                if (phoneNum.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
                    return;
                }
                sendSms(phoneNum, 1);
                break;
            case R.id.btn_get_again:
                String phoneNum2 = mEtPhoneNum.getText().toString().trim();
                if (phoneNum2.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
                    return;
                }
                sendSms(phoneNum2, 1);
                break;
            case R.id.btn_complete:
                String phoneNum3 = mEtPhoneNum.getText().toString().trim();
                if (phoneNum3.isEmpty()) {
                    OwerToastShow.show("请输入手机号");
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
                if (confirmPwd.isEmpty()) {
                    OwerToastShow.show("请确认密码");
                    return;
                }
                if (!password.equals(confirmPwd)) {
                    OwerToastShow.show("两次输入密码不一致");
                    return;
                }
                findPassword(phoneNum3, validateCode, password, 1);
                break;
        }
    }

    private void initView() {
        mEtPhoneNum = (TextView) view.findViewById(R.id.et_phone_num);
        mEtCode = (TextView) view.findViewById(R.id.et_code);
        mEtPwd = (TextView) view.findViewById(R.id.et_pwd);
        mEtConfirmPwd = (TextView) view.findViewById(R.id.et_confirm_pwd);

        mBtnSend = (Button) view.findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        mBtnGetAgain = (Button) view.findViewById(R.id.btn_get_again);
        mBtnGetAgain.setOnClickListener(this);
        mBtnComplete = (Button) view.findViewById(R.id.btn_complete);
        mBtnComplete.setOnClickListener(this);
    }

    /**
     * 找回登陆密码/找回锁定密码
     * @param mobileNo     手机号码
     * @param validateCode 校验码
     * @param newPassword  新密码
     * @param type         请求类型(1-找回登录密码；2-找回锁定密码)
     */
    private void findPassword(String mobileNo, String validateCode, String newPassword, int type) {
        FindPasswordRequest request = new FindPasswordRequest();
        request.setMobileNo(mobileNo);
        request.setValidateCode(validateCode);
        request.setNewPassword(newPassword);
        switch (type) {
            case 1:
                HttpUtils.getInstance().asyncPost(request, GlobalUtils.FIND_PWD_LOGIN_URL, new ICallBack() {
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
                break;
            case 2:
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
                break;
        }
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
}
