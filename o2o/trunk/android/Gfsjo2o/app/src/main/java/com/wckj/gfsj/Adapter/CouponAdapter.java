package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.Coupon;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/11.
 */
public class CouponAdapter extends BaseAdapter {

    private Context mContext;
    private List<Coupon> mCouponList;

    public CouponAdapter(Context context, List<Coupon> list) {
        this.mContext = context;
        this.mCouponList = list;
    }

    @Override
    public int getCount() {
        return mCouponList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCouponList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CouponViewHolder itemHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_coupon, null);
            itemHolder = new CouponViewHolder();
            itemHolder.mIvCouponPic = (ImageView) convertView.findViewById(R.id.iv_coupon_pic);
            itemHolder.mTvCouponNum = (TextView) convertView.findViewById(R.id.tv_coupon_num);
            itemHolder.mTvDeadLine = (TextView) convertView.findViewById(R.id.tv_dead_line);
            itemHolder.mTvPlatformLimit = (TextView) convertView.findViewById(R.id.tv_platform_limit);
            itemHolder.mIvOperate = (ImageView) convertView.findViewById(R.id.iv_operate);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (CouponViewHolder) convertView.getTag();
        }
        final Coupon item = (Coupon) getItem(position);

        itemHolder.mTvCouponNum.setText(item.getName());
        itemHolder.mTvDeadLine.setText(item.getEndTime());

        return convertView;
    }

    class CouponViewHolder {
        ImageView mIvCouponPic;
        TextView mTvCouponNum;
        TextView mTvDeadLine;
        TextView mTvPlatformLimit;
        ImageView mIvOperate;
    }
}
