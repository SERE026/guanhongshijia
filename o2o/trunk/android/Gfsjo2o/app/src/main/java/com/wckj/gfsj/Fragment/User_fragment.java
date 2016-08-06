package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.MainActivity;
import com.wckj.gfsj.Activity.UserCenterActivity;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.LoginRequest;
import com.wckj.gfsj.Bean.LoginResult;
import com.wckj.gfsj.Db.JsonDao;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.TimeUtils;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 * 用户
 */
public class User_fragment extends Fragment implements View.OnClickListener {

    private static final int INTO_USER_CENTER = 100;

    private RelativeLayout mRlLogin;
    private TextView mTvLoginTitle;
    private EditText mEtUsername, mEtPassword;
    private Button mBtnFindPassword, mBtnLogin;
    private JsonDao jsonDao;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        jsonDao =  new JsonDao();
        mRlLogin = (RelativeLayout) view.findViewById(R.id.rl_login);
        mTvLoginTitle = (TextView) view.findViewById(R.id.tv_login_title);
        mEtUsername = (EditText) view.findViewById(R.id.et_username);
        mEtPassword = (EditText) view.findViewById(R.id.et_password);
        mBtnFindPassword = (Button) view.findViewById(R.id.btn_find_password);
        mBtnLogin = (Button) view.findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String userName = mEtUsername.getText().toString().trim();
                String userPwd  = mEtPassword.getText().toString().trim();
                login();
//                if (userName.equals("123") && userPwd.equals("123")) {
                    Intent intent = new Intent(view.getContext(), UserCenterActivity.class);
                    startActivityForResult(intent, INTO_USER_CENTER);
//                } else {
//                    OwerToastShow.show("用户名或密码错误");
//                }
                break;
        }
    }

    private void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginName("lxfeng");
        loginRequest.setPassword("123123");
        HttpUtils.getInstance().asyncPost(loginRequest, GlobalUtils.LOGIN_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onSuccess(String response) {
                jsonDao.insertJson(GlobalUtils.LOGIN_URL, response, TimeUtils.getSystemTime());
                AppApplication.loginResult = JSON.parseObject(response, LoginResult.class);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == INTO_USER_CENTER) {
            MainActivity parentActivity = (MainActivity) getActivity();
            parentActivity.setTabSelection(0);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
