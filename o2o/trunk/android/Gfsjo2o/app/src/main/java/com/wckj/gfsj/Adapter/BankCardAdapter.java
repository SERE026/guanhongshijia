package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Card;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/11.
 */
public class BankCardAdapter extends BaseAdapter {

    private Context mContext;
    private List<Card> mCardList;

    public BankCardAdapter(Context context, List<Card> list) {
        this.mContext = context;
        this.mCardList = list;
    }

    @Override
    public int getCount() {
        return mCardList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BankCardViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_bank_card, null);
            itemHolder = new BankCardViewHolder();
            itemHolder.mTvBankName = (TextView) convertView.findViewById(R.id.tv_bank_name);
            itemHolder.mTvBankCardNum = (TextView) convertView.findViewById(R.id.tv_bank_card_num);
            itemHolder.mTvStatus = (TextView) convertView.findViewById(R.id.tv_status);
            itemHolder.mTvType = (TextView) convertView.findViewById(R.id.tv_type);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (BankCardViewHolder) convertView.getTag();
        }
        final Card item = (Card) getItem(position);
        itemHolder.mTvBankName.setText(item.getBankName());
        itemHolder.mTvBankCardNum.setText(item.getCardNo());
        itemHolder.mTvStatus.setText(item.getStatus());
        itemHolder.mTvType.setText(item.getType());

        return convertView;
    }

    class BankCardViewHolder {
        TextView mTvBankName;
        TextView mTvBankCardNum;
        TextView mTvStatus;
        TextView mTvType;
    }
}
