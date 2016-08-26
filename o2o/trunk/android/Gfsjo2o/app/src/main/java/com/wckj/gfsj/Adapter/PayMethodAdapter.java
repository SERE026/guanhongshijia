package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wckj.gfsj.Bean.PayMethod;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/25.
 */
public class PayMethodAdapter extends BaseAdapter {

    private Context mContext;
    private List<PayMethod> mPayMethodList;

    public PayMethodAdapter(Context context, List<PayMethod> list) {
        this.mContext = context;
        this.mPayMethodList = list;
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

        itemHolder.mCbPay.setText(item.getName());
        itemHolder.mTvPayToast.setText(item.getToast());

        return convertView;
    }

    class PayMethodViewHolder {
        CheckBox mCbPay;
        TextView mTvPayToast;
    }
}
