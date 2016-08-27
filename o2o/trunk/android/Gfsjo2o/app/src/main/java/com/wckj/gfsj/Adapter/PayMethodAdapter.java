package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wckj.gfsj.Bean.PayMethod;
import com.wckj.gfsj.Bean.entity.Coupon;
import com.wckj.gfsj.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rayco on 2016/8/25.
 */
public class PayMethodAdapter extends BaseAdapter {

    private Context mContext;
    private List<PayMethod> mPayMethodList;
    private double mCommodityTotalMoney;
    private List<Coupon> selectedCouponList = new ArrayList<Coupon>();

    public PayMethodAdapter(Context context, double commodityTotalMoney, List<PayMethod> list) {
        this.mContext = context;
        this.mCommodityTotalMoney = commodityTotalMoney;
        this.mPayMethodList = list;
    }

    public List<Coupon> getSelectedCouponList() {
        return selectedCouponList;
    }

    @Override
    public int getCount() {
        return mPayMethodList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPayMethodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PayMethodViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pay_method, null);
            itemHolder = new PayMethodViewHolder();
            itemHolder.mCbPay = (CheckBox) convertView.findViewById(R.id.cb_pay);
            itemHolder.mTvPayToast = (TextView) convertView.findViewById(R.id.tv_pay_toast);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (PayMethodViewHolder) convertView.getTag();
        }

        final PayMethod item = (PayMethod) getItem(position);

        itemHolder.mTvPayToast.setText(item.getToast());

        itemHolder.mCbPay.setText(item.getName());
        itemHolder.mCbPay.setTag(position);
        if (position == 0) {// 余额现在不能用
            itemHolder.mCbPay.setEnabled(false);
        } else if (position == 1) {// 支付宝
            itemHolder.mCbPay.setChecked(true);
            itemHolder.mCbPay.setClickable(false);
        } else {
            if (item.isCancelCheck()) {
                itemHolder.mCbPay.setChecked(false);
            }
        }

        if (item.getCoupon() != null) {
            // 达到使用金额才可使用
            if (mCommodityTotalMoney < item.getCoupon().getConstraintValue()) {
                itemHolder.mCbPay.setEnabled(false);
            }

            itemHolder.mCbPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int)view.getTag();
                    if (mPayMethodList.get(pos).getCoupon().getSameUse() == 0) {
                        for (PayMethod payMethod : mPayMethodList) {
                            if (payMethod.getCoupon() != null) {
                                if (payMethod.getId() != mPayMethodList.get(pos).getId()) {
                                    payMethod.setCancelCheck(true);
                                } else {
                                    payMethod.setCancelCheck(false);
                                }
                            }
                        }
                        if (((CheckBox)view).isChecked()) {
                            selectedCouponList.clear();
                            selectedCouponList.add(mPayMethodList.get(pos).getCoupon());
                        } else {
                            selectedCouponList.clear();
                        }
                    } else {
                        for (PayMethod payMethod : mPayMethodList) {
                            if (payMethod.getCoupon() != null) {
                                if (payMethod.getCoupon().getSameUse() == 0) {
                                    payMethod.setCancelCheck(true);
                                    if (selectedCouponList.contains(payMethod.getCoupon())) {
                                        selectedCouponList.remove(payMethod.getCoupon());
                                    }
                                } else {
                                    payMethod.setCancelCheck(false);
                                }
                            }
                        }
                        if (((CheckBox)view).isChecked()) {
                            selectedCouponList.add(mPayMethodList.get(pos).getCoupon());
                        } else {
                            if (selectedCouponList.contains(mPayMethodList.get(pos).getCoupon())) {
                                selectedCouponList.remove(mPayMethodList.get(pos).getCoupon());
                            }
                        }
                    }
                    notifyDataSetChanged();
                }
            });
        }

        return convertView;
    }

    class PayMethodViewHolder {
        CheckBox mCbPay;
        TextView mTvPayToast;
    }
}
