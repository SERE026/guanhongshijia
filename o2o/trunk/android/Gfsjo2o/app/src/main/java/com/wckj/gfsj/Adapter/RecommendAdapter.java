package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Recommend;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.ImageLoaderUtil;

import java.util.List;

/**
 * Created by jinlei on 2016/7/21.
 */
public class RecommendAdapter extends BaseAdapter{
    private Context mcon;
    //新品推荐列表
    private List<Recommend> newList;
    public RecommendAdapter(Context mcon, List<Recommend> mList) {
        this.mcon=mcon;
        this.newList=mList;
    }

    @Override
    public int getCount() {
        return newList.size();
    }

    @Override
    public Object getItem(int position) {
        return newList.get(position);
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
        final Recommend item = (Recommend) getItem(position);
       ImageLoaderUtil.getInstance().displayImageView(item.getImageUrl(),holder.iv_shopping_pic);
        if(item.getGoodsStory()!=null){
            holder.tv_name.setText(item.getGoodsStory());
        }

        holder.tv_title_desc.setText(item.getShortDesc());
        return convertView;
    }
    static class ViewHolder {
        ImageView iv_shopping_pic;
        TextView tv_title_desc;
        TextView tv_name;
    }
}
