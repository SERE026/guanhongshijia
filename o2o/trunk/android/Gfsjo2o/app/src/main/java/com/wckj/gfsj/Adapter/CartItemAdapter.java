package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.R;

import java.util.List;

/**
 * Created by rayco on 2016/8/11.
 */
public class CartItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<CartItem> mCartItemList;

    public CartItemAdapter(Context context, List<CartItem> list) {
        this.mContext = context;
        this.mCartItemList = list;
    }

    public int getItemViewType(int position) {
        if (mCartItemList.get(position).getId().equals("-1")) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getCount() {
        return mCartItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCartItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartItemViewHolder itemHolder;
        CartItemHeadViewHolder itemHeadHolder;

        int type = getItemViewType(position);
        switch (type) {
            case 0:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cart_item, null);
                    itemHolder = new CartItemViewHolder();
                    itemHolder.mIvGoodsPic = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
                    itemHolder.mTvGoodsName = (TextView) convertView.findViewById(R.id.tv_goods_name);
                    itemHolder.mTvUserName = (TextView) convertView.findViewById(R.id.tv_user_name);
                    convertView.setTag(itemHolder);
                } else {
                    itemHolder = (CartItemViewHolder) convertView.getTag();
                }
                final CartItem item = (CartItem) getItem(position);
                break;
            case 1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cart_item_head, null);
                    itemHeadHolder = new CartItemHeadViewHolder();
                    itemHeadHolder.mTvDate = (TextView) convertView.findViewById(R.id.tv_date);
                    itemHeadHolder.mTvOrderNum = (TextView) convertView.findViewById(R.id.tv_order_number);
                    convertView.setTag(itemHeadHolder);
                } else {
                    itemHeadHolder = (CartItemHeadViewHolder) convertView.getTag();
                }
                break;
            default:
                break;
        }

        return convertView;
    }

    class CartItemViewHolder {
        ImageView mIvGoodsPic;
        TextView mTvGoodsName;
        TextView mTvUserName;
    }

    class CartItemHeadViewHolder {
        TextView mTvDate;
        TextView mTvOrderNum;
    }
}
