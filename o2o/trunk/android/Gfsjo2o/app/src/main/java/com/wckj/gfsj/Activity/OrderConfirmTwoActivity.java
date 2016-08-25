package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.wckj.gfsj.Bean.CreateOrderRequest;
import com.wckj.gfsj.Bean.entity.AddressMember;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;
import java.util.List;

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
    private CheckBox cbBalancePay, cbCouponPay, cbAliPay, cbTimeNotLimit, cbWeekday, cbWeekend;
    private Button btnNext;

    private AddressMember addressMember;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();

    @Override
    protected void init() {
        Intent intent = this.getIntent();
        addressMember = (AddressMember) intent.getSerializableExtra("address");
        cartItemList = (List<CartItem>) intent.getSerializableExtra("cartItemList");
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
                if (!cbAliPay.isChecked()) {
                    OwerToastShow.show("请选择支付方式");
                    return;
                }

                if (!cbTimeNotLimit.isChecked() && !cbWeekday.isChecked() && !cbWeekend.isChecked()) {
                    OwerToastShow.show("请选择收货时间");
                    return;
                }

                CreateOrderRequest createOrderRequest = new CreateOrderRequest();
                createOrderRequest.setAddressMember(addressMember);
                createOrderRequest.setDlytypeId("2");// 快递ID, 默认2顺丰
//                createOrderRequest.setCoupons("1, ");// 优惠券ID, 用","隔开
                createOrderRequest.setDlyType("1");// 1-物流，0-上门提货
                createOrderRequest.setAccountStr("1");// 是否使用账号支付，0-是，1-否 (现在支持支付宝)
                createOrderRequest.setPlayType("1");// 支付宝

                Bundle bundle = new Bundle();
                bundle.putSerializable("order", createOrderRequest);

                Intent intent = new Intent();
                intent.setClass(this, OrderConfirmThreeActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("cartItemList", (ArrayList<CartItem>)cartItemList);
                startActivity(intent);
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

        cbBalancePay = (CheckBox) view.findViewById(R.id.cb_balance_pay);
        cbAliPay = (CheckBox) view.findViewById(R.id.cb_alipay);
        cbCouponPay = (CheckBox) view.findViewById(R.id.cb_coupon_pay1);
        cbTimeNotLimit = (CheckBox) view.findViewById(R.id.cb_time_not_limit);
        cbWeekday = (CheckBox) view.findViewById(R.id.cb_weekday);
        cbWeekend = (CheckBox) view.findViewById(R.id.cb_weekend);

        cbTimeNotLimit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbWeekday.setChecked(false);
                    cbWeekend.setChecked(false);
                    addressMember.setReceiveDate("时间不限");
                }
            }
        });

        cbWeekday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbTimeNotLimit.setChecked(false);
                    cbWeekend.setChecked(false);
                    addressMember.setReceiveDate("工作日");
                }
            }
        });

        cbWeekend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbWeekday.setChecked(false);
                    cbTimeNotLimit.setChecked(false);
                    addressMember.setReceiveDate("节假日");
                }
            }
        });

        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }
}
