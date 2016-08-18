package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/8/17.
 */
public class BindBankCardctivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private EditText mEtIdNum, mEtName, mEtPhoneNum, mEtBankNum;
    private Button mBtnNext;

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
        view = inflater.inflate(R.layout.activity_bind_bank_card, null);
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
            case R.id.btn_next:
                Intent intent = new Intent(view.getContext(), BindBankCardVerifyActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        mEtIdNum = (EditText) view.findViewById(R.id.et_id_num);
        mEtName = (EditText) view.findViewById(R.id.et_name);
        mEtPhoneNum = (EditText) view.findViewById(R.id.et_phone_num);
        mEtBankNum = (EditText) view.findViewById(R.id.et_bank_num);
        mBtnNext = (Button) view.findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
