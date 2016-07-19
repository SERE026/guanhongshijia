package com.wckj.gfsj.Fragment;

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

import com.wckj.gfsj.R;

/**
 * Created by 小爱爱 on 2016/7/18.
 * 用户
 */
public class User_fragment extends Fragment {

    private RelativeLayout mRlLogin;
    private TextView mTvLoginTitle;
    private EditText mEtUsername, mEtPassword;
    private Button mBtnFindPassword, mBtnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
//        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
//        tv_msg.setText("用户中心");

        mRlLogin = (RelativeLayout) view.findViewById(R.id.rl_login);
        mTvLoginTitle = (TextView) view.findViewById(R.id.tv_login_title);
        mEtUsername = (EditText) view.findViewById(R.id.et_username);
        mEtPassword = (EditText) view.findViewById(R.id.et_password);
        mBtnFindPassword = (Button) view.findViewById(R.id.btn_find_password);
        mBtnLogin = (Button) view.findViewById(R.id.btn_login);

        return view;
    }
}
