package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.PayMethodAdapter;
import com.wckj.gfsj.Bean.CreateOrderRequest;
import com.wckj.gfsj.Bean.PayMethod;
import com.wckj.gfsj.Bean.entity.AddressMember;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.Bean.entity.Coupon;
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
    private ListView lvPayMethod;

    private TextView tvReceiptDate;
    private TextView tvTimeNotLimitToast;
    private TextView tvWeekdayToast;
    private TextView tvWeekendToast1;
    private CheckBox cbTimeNotLimit, cbWeekday, cbWeekend;
    private Button btnNext;

    private AddressMember addressMember;
    private List<CartItem> cartItemList = new ArrayList<CartItem>();
    private List<Coupon> couponList = new ArrayList<Coupon>();
    private List<PayMethod> payMethodList = new ArrayList<PayMethod>();
    private String addressName;
    private String dlyTypeId;
    private double commodityTotalMoney = 0;

    private PayMethodAdapter payMethodAdapter;

    @Override
    protected void init() {
        Intent intent = this.getIntent();
        addressMember = (AddressMember) intent.getSerializableExtra("address");
        cartItemList = (List<CartItem>) intent.getSerializableExtra("cartItemList");
        couponList = (List<Coupon>) intent.getSerializableExtra("couponList");
        addressName = intent.getStringExtra("addressName");
        dlyTypeId = intent.getStringExtra("dlyTypeId");

        for (CartItem item : cartItemList) {
            commodityTotalMoney += (item.getGoodsDetail().getPrice() * item.getCount());
        }

        PayMethod payMethod1 = new PayMethod();
        payMethod1.setId(0);
        payMethod1.setName("优先使用余额支付");
        payMethod1.setToast("余额不足选择其他支付方式");
        payMethod1.setCoupon(null);
        payMethod1.setCancelCheck(false);
        payMethodList.add(payMethod1);

        PayMethod payMethod2 = new PayMethod();
        payMethod2.setId(1);
        payMethod2.setName("使用支付宝即时到账");
        payMethod2.setToast("无需开通网银无需手续费");
        payMethod2.setCoupon(null);
        payMethod2.setCancelCheck(false);
        payMethodList.add(payMethod2);

        int id = 2;
        for (Coupon coupon : couponList) {
            PayMethod payMethod = new PayMethod();
            payMethod.setId(id++);
            payMethod.setName("使用优惠券");
            if (coupon.getSameUse() == 1) {
                payMethod.setToast(coupon.getName() + "(可以与其他券一起使用)");
            } else if (coupon.getSameUse() == 0) {
                payMethod.setToast(coupon.getName() + "(不可与其他券一起使用)");
            }
            payMethod.setCoupon(coupon);
            payMethod.setCancelCheck(false);
            payMethodList.add(payMethod);
        }

        payMethodAdapter = new PayMethodAdapter(this, commodityTotalMoney, payMethodList);
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
                if (!cbTimeNotLimit.isChecked() && !cbWeekday.isChecked() && !cbWeekend.isChecked()) {
                    OwerToastShow.show("请选择收货时间");
                    return;
                }

                List<Coupon> list = payMethodAdapter.getSelectedCouponList();
                double discountMoney = 0;
                String couponIds = "";
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType() == 1) {
                        double minMoney = 0;
                        if (list.get(i).getReduceValue() <= list.get(i).getMaxAmount()) {
                            minMoney = list.get(i).getReduceValue();
                        } else {
                            minMoney = list.get(i).getMaxAmount();
                        }
                        discountMoney += minMoney;
                    } else if (list.get(i).getType() == 2) {
                        double minMoney = 0;
                        if (commodityTotalMoney * list.get(i).getDiscountValue() <= list.get(i).getMaxAmount()) {
                            minMoney = commodityTotalMoney * list.get(i).getDiscountValue();
                        } else {
                            minMoney = list.get(i).getMaxAmount();
                        }
                        discountMoney += minMoney;
                    }
                    if (i == list.size() - 1) {
                        couponIds = couponIds + list.get(i).getId();
                    } else {
                        couponIds = couponIds + list.get(i).getId() + ",";
                    }
                }

                String shopIds = "";
                for (int i = 0; i < cartItemList.size(); i++) {
                    if (i == cartItemList.size() - 1) {
                        shopIds = shopIds + cartItemList.get(i).getId();
                    } else {
                        shopIds = shopIds + cartItemList.get(i).getId() + ";";
                    }
                }

                CreateOrderRequest createOrderRequest = new CreateOrderRequest();
                createOrderRequest.setAddressMember(addressMember);
                createOrderRequest.setDlytypeId("2");// 快递ID, 默认2顺丰
                createOrderRequest.setCoupons(couponIds);// 优惠券ID, 用","隔开
                createOrderRequest.setDlyType("1");// 1-物流，0-上门提货
                createOrderRequest.setAccountStr("1");// 是否使用账号支付，0-是，1-否 (现在支持支付宝)
                createOrderRequest.setPlayType("1");// 支付宝
                createOrderRequest.setShop(shopIds);

                Bundle bundle = new Bundle();
                bundle.putSerializable("order", createOrderRequest);

                Intent intent = new Intent();
                intent.setClass(this, OrderConfirmThreeActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("cartItemList", (ArrayList<CartItem>)cartItemList);
                intent.putExtra("addressName", addressName);
                intent.putExtra("dlyTypeId", dlyTypeId);
                intent.putExtra("discountMoney", discountMoney);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        tvOrderConfirm = (TextView) view.findViewById(R.id.tv_order_confirm);
        tvPayMethod = (TextView) view.findViewById(R.id.tv_pay_method);

        lvPayMethod = (ListView) view.findViewById(R.id.lv_pay_method);
        lvPayMethod.setDividerHeight(0);
        lvPayMethod.setAdapter(payMethodAdapter);
        payMethodAdapter.notifyDataSetChanged();

        tvReceiptDate = (TextView) view.findViewById(R.id.tv_receipt_date);
        tvTimeNotLimitToast = (TextView) view.findViewById(R.id.tv_time_not_limit_toast);
        tvWeekdayToast = (TextView) view.findViewById(R.id.tv_weekday_toast);
        tvWeekendToast1 = (TextView) view.findViewById(R.id.tv_weekend_toast1);

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
