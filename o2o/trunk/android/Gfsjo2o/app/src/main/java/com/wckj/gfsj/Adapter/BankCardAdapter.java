package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.wckj.gfsj.Bean.entity.Card;

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

        if (convertView == null) {

        } else {

        }

        return convertView;
    }
}
