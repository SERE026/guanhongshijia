package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.AgencyFeeItem;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/11.
 */
public class AgencyFeeItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<AgencyFeeItem> mAgencyFeeItemList;

    public AgencyFeeItemAdapter(Context context, List<AgencyFeeItem> list) {
        this.mContext = context;
        this.mAgencyFeeItemList = list;
    }

    @Override
    public int getCount() {
        return mAgencyFeeItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAgencyFeeItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AgencyFeeItemViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_agency_fee, null);
            itemHolder = new AgencyFeeItemViewHolder();
            itemHolder.mTvDate = (TextView) convertView.findViewById(R.id.tv_date);
            itemHolder.mTvOrderNum = (TextView) convertView.findViewById(R.id.tv_order_num);
            itemHolder.mTvDealPrice = (TextView) convertView.findViewById(R.id.tv_deal_price);
            itemHolder.mTvDeductPercent = (TextView) convertView.findViewById(R.id.tv_deduct_percent);
            itemHolder.mTvDeductMoney = (TextView) convertView.findViewById(R.id.tv_deduct_money);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (AgencyFeeItemViewHolder) convertView.getTag();
        }
        final AgencyFeeItem item = (AgencyFeeItem) getItem(position);
        itemHolder.mTvDate.setText(item.getDate());
        itemHolder.mTvOrderNum.setText(item.getOrderNo());
        itemHolder.mTvDealPrice.setText(item.getPrice() + "");
        itemHolder.mTvDeductPercent.setText(item.getPercent());
        itemHolder.mTvDeductMoney.setText(item.getAmount() + "");

        return convertView;
    }

    class AgencyFeeItemViewHolder {
        TextView mTvDate;
        TextView mTvOrderNum;
        TextView mTvDealPrice;
        TextView mTvDeductPercent;
        TextView mTvDeductMoney;
    }
}
