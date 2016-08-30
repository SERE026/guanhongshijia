package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Category;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.ImageLoaderUtil;

import java.util.List;

/**
 * Created by jinlei on 2016/7/21.
 */
public class MoreRecommendAdapter extends BaseAdapter{
    private Context mcon;
    private List<Category> mList;
    public MoreRecommendAdapter(Context mcon, List<Category> mList) {
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
            convertView = LayoutInflater.from(mcon).inflate(R.layout.item_more_recommend, null);
            holder = new ViewHolder();
            holder.rl_recommend_color = (RelativeLayout) convertView.findViewById(R.id.rl_recommend_color);
            holder.iv_more_reocommend_pic = (ImageView) convertView.findViewById(R.id.iv_more_reocommend_pic);
            holder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Category item = (Category) getItem(position);
        holder.rl_recommend_color.setBackgroundColor(mcon.getResources().getColor(R.color.color_2c3c5c));
     ImageLoaderUtil.getInstance().displayImageView(item.getImageUrl(),holder.iv_more_reocommend_pic,R.drawable.icon_public_classification);
        holder.tv_desc.setText(item.getTitle());
        return convertView;
    }
    static class ViewHolder {
        RelativeLayout rl_recommend_color;
        ImageView iv_more_reocommend_pic;
        TextView tv_desc;
    }
}
