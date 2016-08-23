package com.wckj.gfsj.Activity;

import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

public class OrderConfirmThreeActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private TextView tvOrderConfirm;
    private TextView tvCommodityDetail;
    private TextView tvExplain;
    private PercentRelativeLayout rlHead;
    private TextView tvCommodityName;
    private TextView tvSubtotal;
    private TextView tvAmount;
    private TextView tvUnitPrice;
    private ListView lvCommodityList;
    private TextView tvCommodityTotalMoney;
    private TextView tvCommodityTotal;
    private TextView tvFreightMoney;
    private TextView tvFreight;
    private TextView tvTotalMoney;
    private TextView tvTotal;
    private TextView tvDiscountMoney;
    private TextView tvDiscount;
    private TextView tvActualTotalMoney;
    private TextView tvActualTotal;
    private TextView tvShouldPayMoney;
    private TextView tvShouldPay;
    private TextView tvSendToAddress;
    private TextView tvSendTo;

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
        view = inflater.inflate(R.layout.activity_order_confirm_three, null);
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
            case R.id.btn_commit_order:
                //TODO implement
                break;
        }
    }

    private void initView() {
        tvOrderConfirm = (TextView) view.findViewById(R.id.tv_order_confirm);
        tvCommodityDetail = (TextView) view.findViewById(R.id.tv_commodity_detail);
        tvExplain = (TextView) view.findViewById(R.id.tv_explain);
        rlHead = (PercentRelativeLayout) view.findViewById(R.id.rl_head);
        tvCommodityName = (TextView) view.findViewById(R.id.tv_commodity_name);
        tvSubtotal = (TextView) view.findViewById(R.id.tv_subtotal);
        tvAmount = (TextView) view.findViewById(R.id.tv_amount);
        tvUnitPrice = (TextView) view.findViewById(R.id.tv_unit_price);
        lvCommodityList = (ListView) view.findViewById(R.id.lv_commodity_list);
        tvCommodityTotalMoney = (TextView) view.findViewById(R.id.tv_commodity_total_money);
        tvCommodityTotal = (TextView) view.findViewById(R.id.tv_commodity_total);
        tvFreightMoney = (TextView) view.findViewById(R.id.tv_freight_money);
        tvFreight = (TextView) view.findViewById(R.id.tv_freight);
        tvTotalMoney = (TextView) view.findViewById(R.id.tv_total_money);
        tvTotal = (TextView) view.findViewById(R.id.tv_total);
        tvDiscountMoney = (TextView) view.findViewById(R.id.tv_discount_money);
        tvDiscount = (TextView) view.findViewById(R.id.tv_discount);
        tvActualTotalMoney = (TextView) view.findViewById(R.id.tv_actual_total_money);
        tvActualTotal = (TextView) view.findViewById(R.id.tv_actual_total);
        tvShouldPayMoney = (TextView) view.findViewById(R.id.tv_should_pay_money);
        tvShouldPay = (TextView) view.findViewById(R.id.tv_should_pay);
        tvSendToAddress = (TextView) view.findViewById(R.id.tv_send_to_address);
        tvSendTo = (TextView) view.findViewById(R.id.tv_send_to);
        view.findViewById(R.id.btn_commit_order).setOnClickListener(this);
    }
}
