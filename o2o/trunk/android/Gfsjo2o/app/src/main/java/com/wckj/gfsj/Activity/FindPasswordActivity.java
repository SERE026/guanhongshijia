package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
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

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/30.
 */
public class FindPasswordActivity extends BaseNewActivity implements View.OnClickListener {

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
        }
    }

    private void initView() {
//        findPassword("", "1234", "123456", 1);
//        sendSms("", 1);
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
                        FindPasswordResult json = JSON.parseObject(response, FindPasswordResult.class);
                        LogUtil.i(response + "");
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
                        FindPasswordResult json = JSON.parseObject(response, FindPasswordResult.class);
                        LogUtil.i(response + "");
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
                SmsResult json = JSON.parseObject(response, SmsResult.class);
                LogUtil.i(response + "");
            }
        });
    }
}
