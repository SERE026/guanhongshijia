package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.OrderConfirmAdapter;
import com.wckj.gfsj.Bean.CreateOrderRequest;
import com.wckj.gfsj.Bean.CreateOrderResult;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

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
    private Button btnCommitOrder;

    private CreateOrderRequest createOrderRequest;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();
    private String addressName;
    private double discountMoney;

    private OrderConfirmAdapter confirmAdapter;

    @Override
    protected void init() {
        Intent intent = this.getIntent();
        createOrderRequest = (CreateOrderRequest) intent.getSerializableExtra("order");
        cartItemList = (List<CartItem>) intent.getSerializableExtra("cartItemList");
        addressName = intent.getStringExtra("addressName");
        discountMoney = intent.getDoubleExtra("discountMoney", 0);

        confirmAdapter = new OrderConfirmAdapter(this, cartItemList);
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
        initViewData();
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
                createOrder();
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
        btnCommitOrder = (Button) view.findViewById(R.id.btn_commit_order);
        btnCommitOrder.setOnClickListener(this);
        lvCommodityList.setAdapter(confirmAdapter);
        confirmAdapter.notifyDataSetChanged();
    }

    private void initViewData() {
        tvSendToAddress.setText(addressName);

        DecimalFormat df = new DecimalFormat("0.00");

        double commodityTotalMoney = 0;
        for (CartItem item : cartItemList) {
            commodityTotalMoney += (item.getGoodsDetail().getPrice() * item.getCount());
        }
        tvCommodityTotalMoney.setText(df.format(commodityTotalMoney));

        double freightMoney = 0;
        tvFreightMoney.setText(df.format(freightMoney));

        double totalMoney = commodityTotalMoney+freightMoney;
        tvTotalMoney.setText(df.format(totalMoney));

        tvDiscountMoney.setText(df.format(discountMoney));

        double actualTotalMoney = totalMoney - discountMoney;
        tvActualTotalMoney.setText(df.format(actualTotalMoney));

        tvShouldPayMoney.setText(df.format(actualTotalMoney));
    }

    /**
     * 创建订单
     */
    private void createOrder() {
        HttpUtils.getInstance().asyncPost(createOrderRequest, GlobalUtils.ORDER_CREATE_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
                OwerToastShow.show("创建订单失败");
            }

            @Override
            public void onSuccess(String response) {
                CreateOrderResult result = JSON.parseObject(response, CreateOrderResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    double payPrice = result.getPayPrice();
                    String tradeNo = result.getTradeNo();

                    Intent intent = new Intent();
                    intent.setClass(OrderConfirmThreeActivity.this, OrderConfirmFourActivity.class);
                    intent.putExtra("payPrice", payPrice);
                    intent.putExtra("tradeNo", tradeNo);
                    startActivity(intent);
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
