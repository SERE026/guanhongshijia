package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

public class OrderConfirmFourActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private TextView tvOrderPay;
    private TextView tvDesc;
    private TextView tvOrderNumber;
    private TextView tvShouldPay;
    private TextView tvShouldPayMoney;
    private TextView tvDesc2;
    private Button btnPayNow;

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
        view = inflater.inflate(R.layout.activity_order_confirm_four, null);
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
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_pay_now:
                //TODO, implement
                break;
        }
    }

    private void initView() {
        tvOrderPay = (TextView) view.findViewById(R.id.tv_order_pay);
        tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        tvOrderNumber = (TextView) view.findViewById(R.id.tv_order_number);
        tvShouldPay = (TextView) view.findViewById(R.id.tv_should_pay);
        tvShouldPayMoney = (TextView) view.findViewById(R.id.tv_should_pay_money);
        tvDesc2 = (TextView) findViewById(R.id.tv_desc2);
        btnPayNow = (Button) view.findViewById(R.id.btn_pay_now);
        btnPayNow.setOnClickListener(this);
    }
}
