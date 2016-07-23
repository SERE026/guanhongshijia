package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wckj.gfsj.Bean.Commodity_level_one;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by jinlei on 2016/7/21.
 */
public class RecommendAdapter extends BaseAdapter{
    private Context mcon;
    private List<Commodity_level_one> mList;
    public RecommendAdapter(Context mcon, List<Commodity_level_one> mList) {
        this.mcon=mcon;
        this.mList=mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mcon).inflate(R.layout.item_recommend_shoping, null);
            holder = new ViewHolder();
            holder.iv_shopping_pic = (ImageView) convertView.findViewById(R.id.iv_shopping_pic);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_title_desc = (TextView) convertView.findViewById(R.id.tv_title_desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Commodity_level_one item = (Commodity_level_one) getItem(position);
        holder.iv_shopping_pic.setImageResource(R.drawable.icon_public_image);
        holder.tv_name.setText("直降200快");
        holder.tv_title_desc.setText("厂家直销快来购买");
        return convertView;
    }
    static class ViewHolder {
        ImageView iv_shopping_pic;
        TextView tv_title_desc;
        TextView tv_name;
    }
}
