package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Area;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/24.
 */
public class AreaAdapter extends BaseAdapter {

    private Context mContext;
    private List<Area> mAreaList;

    public AreaAdapter(Context context, List<Area> list) {
        this.mContext = context;
        this.mAreaList = list;
    }

    @Override
    public int getCount() {
        return mAreaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAreaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AreaViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_area, null);
            itemHolder = new AreaViewHolder();
            itemHolder.mTvName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (AreaViewHolder) convertView.getTag();
        }

        final Area item = (Area) getItem(position);
        itemHolder.mTvName.setText(item.getName());

        return convertView;
    }

    class AreaViewHolder {
        TextView mTvName;
    }
}
