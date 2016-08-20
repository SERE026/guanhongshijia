package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.TimeUtils;

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
                    itemHolder.mTvMoney = (TextView) convertView.findViewById(R.id.tv_money);
                    itemHolder.mTvStatus = (TextView) convertView.findViewById(R.id.tv_status);
                    convertView.setTag(itemHolder);
                } else {
                    if (convertView.getTag() instanceof CartItemViewHolder) {
                        itemHolder = (CartItemViewHolder) convertView.getTag();
                    } else {
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cart_item, null);
                        itemHolder = new CartItemViewHolder();
                        itemHolder.mIvGoodsPic = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
                        itemHolder.mTvGoodsName = (TextView) convertView.findViewById(R.id.tv_goods_name);
                        itemHolder.mTvUserName = (TextView) convertView.findViewById(R.id.tv_user_name);
                        itemHolder.mTvMoney = (TextView) convertView.findViewById(R.id.tv_money);
                        itemHolder.mTvStatus = (TextView) convertView.findViewById(R.id.tv_status);
                        convertView.setTag(itemHolder);
                    }
                }
                CartItem item = (CartItem) getItem(position);

                itemHolder.mTvGoodsName.setText(item.getGoodsDetail().getName());
                itemHolder.mTvUserName.setText(AppApplication.loginResult.getLoginName());
                itemHolder.mTvMoney.setText(String.valueOf(item.getGoodsDetail().getPrice()));
                itemHolder.mTvStatus.setText(item.getGoodsDetail().getType());

                break;
            case 1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cart_item_head, null);
                    itemHeadHolder = new CartItemHeadViewHolder();
                    itemHeadHolder.mTvDate = (TextView) convertView.findViewById(R.id.tv_date);
                    itemHeadHolder.mTvOrderNum = (TextView) convertView.findViewById(R.id.tv_order_number);
                    convertView.setTag(itemHeadHolder);
                } else {
                    if (convertView.getTag() instanceof CartItemHeadViewHolder) {
                        itemHeadHolder = (CartItemHeadViewHolder) convertView.getTag();
                    } else {
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cart_item_head, null);
                        itemHeadHolder = new CartItemHeadViewHolder();
                        itemHeadHolder.mTvDate = (TextView) convertView.findViewById(R.id.tv_date);
                        itemHeadHolder.mTvOrderNum = (TextView) convertView.findViewById(R.id.tv_order_number);
                        convertView.setTag(itemHeadHolder);
                    }
                }

                CartItem cartItem = (CartItem) getItem(position);

                int timeStamp = Integer.valueOf(cartItem.getGoodsDetail().getName());
                itemHeadHolder.mTvDate.setText(TimeUtils.showDateAndTime(timeStamp));
                itemHeadHolder.mTvOrderNum.setText("订单号：" + cartItem.getGoodsDetail().getId());
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
        TextView mTvMoney;
        TextView mTvStatus;
    }

    class CartItemHeadViewHolder {
        TextView mTvDate;
        TextView mTvOrderNum;
    }
}
