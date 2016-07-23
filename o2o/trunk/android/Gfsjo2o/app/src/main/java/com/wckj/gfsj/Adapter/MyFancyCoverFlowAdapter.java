package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.dalong.francyconverflow.FancyCoverFlow;
import com.dalong.francyconverflow.FancyCoverFlowAdapter;
import com.wckj.gfsj.Bean.Commodity_level_one;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class MyFancyCoverFlowAdapter extends FancyCoverFlowAdapter {

    private Context mContext;

    public List<Commodity_level_one> mList;

    public MyFancyCoverFlowAdapter(Context context, List<Commodity_level_one> list) {
        mContext = context;
        this.mList = list;
    }
    @Override
    public View getCoverFlowItem(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fancy_cverflow, null);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            convertView.setLayoutParams(new FancyCoverFlow.LayoutParams(width / 3, FancyCoverFlow.LayoutParams.WRAP_CONTENT));
            holder = new ViewHolder();
            holder.iv_scro_main = (ImageView) convertView.findViewById(R.id.iv_scro_main);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Commodity_level_one item = (Commodity_level_one) getItem(position);
        holder.iv_scro_main.setImageResource(R.drawable.icon_public_image);

        return convertView;
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
        return 0;
    }

    static class ViewHolder {
        ImageView iv_scro_main;
    }
}
