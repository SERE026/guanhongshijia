package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

public class OrderConfirmTwoActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private TextView tvOrderConfirm;
    private TextView tvPayMethod;
    private TextView tvBalancePayToast;
    private TextView tvAlipayToast;
    private TextView tvCouponPayToast1;
    private TextView tvCouponPayToast2;
    private TextView tvReceiptDate;
    private TextView tvTimeNotLimitToast;
    private TextView tvWeekdayToast;
    private TextView tvWeekendToast1;
    private Button btnNext;

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
        view = inflater.inflate(R.layout.activity_order_confirm_two, null);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.btn_next:
//                Intent intent = new Intent(view.getContext(), OrderConfirmThreeActivity.class);
//                startActivity(intent);
                break;
        }
    }

    private void initView() {
        tvOrderConfirm = (TextView) view.findViewById(R.id.tv_order_confirm);
        tvPayMethod = (TextView) view.findViewById(R.id.tv_pay_method);
        tvBalancePayToast = (TextView) view.findViewById(R.id.tv_balance_pay_toast);
        tvAlipayToast = (TextView) view.findViewById(R.id.tv_alipay_toast);
        tvCouponPayToast1 = (TextView) view.findViewById(R.id.tv_coupon_pay_toast1);
        tvCouponPayToast2 = (TextView) view.findViewById(R.id.tv_coupon_pay_toast2);
        tvReceiptDate = (TextView) view.findViewById(R.id.tv_receipt_date);
        tvTimeNotLimitToast = (TextView) view.findViewById(R.id.tv_time_not_limit_toast);
        tvWeekdayToast = (TextView) view.findViewById(R.id.tv_weekday_toast);
        tvWeekendToast1 = (TextView) view.findViewById(R.id.tv_weekend_toast1);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }

    private CheckBox getCbBalancePay(){
        return (CheckBox) findViewById(R.id.cb_balance_pay);
    }

    private CheckBox getCbAlipay(){
        return (CheckBox) findViewById(R.id.cb_alipay);
    }

    private CheckBox getCbCouponPay1(){
        return (CheckBox) findViewById(R.id.cb_coupon_pay1);
    }

    private CheckBox getCbCouponPay2(){
        return (CheckBox) findViewById(R.id.cb_coupon_pay2);
    }

    private CheckBox getCbTimeNotLimit(){
        return (CheckBox) findViewById(R.id.cb_time_not_limit);
    }

    private CheckBox getCbWeekday(){
        return (CheckBox) findViewById(R.id.cb_weekday);
    }

    private CheckBox getCbWeekend(){
        return (CheckBox) findViewById(R.id.cb_weekend);
    }
}
