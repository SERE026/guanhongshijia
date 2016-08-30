package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Dlytype;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/24.
 */
public class DlyTypeAdapter extends BaseAdapter {

    private Context mContext;
    private List<Dlytype> mDlyList;

    public DlyTypeAdapter(Context context, List<Dlytype> list) {
        this.mContext = context;
        this.mDlyList = list;
    }

    @Override
    public int getCount() {
        return mDlyList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDlyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DlyViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_dly_type, null);
            itemHolder = new DlyViewHolder();
            itemHolder.mTvName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (DlyViewHolder) convertView.getTag();
        }

        final Dlytype item = (Dlytype) getItem(position);
        itemHolder.mTvName.setText(item.getDlyName());

        return convertView;
    }

    class DlyViewHolder {
        TextView mTvName;
    }
}
