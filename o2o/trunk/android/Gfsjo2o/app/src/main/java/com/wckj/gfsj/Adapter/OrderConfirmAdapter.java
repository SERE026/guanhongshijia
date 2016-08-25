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
import com.wckj.gfsj.Utils.ImageLoaderUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by rayco on 2016/8/25.
 */
public class OrderConfirmAdapter extends BaseAdapter {

    private Context mContext;
    private List<CartItem> mCartItemList;

    public OrderConfirmAdapter(Context context, List<CartItem> list) {
        this.mContext = context;
        this.mCartItemList = list;
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

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_order_confirm, null);
            itemHolder = new CartItemViewHolder();
            itemHolder.mIvShoppingPic = (ImageView) convertView.findViewById(R.id.iv_shopping_pic);
            itemHolder.mTvShoppingDesc = (TextView) convertView.findViewById(R.id.tv_shopping_desc);
            itemHolder.mTvFlag = (TextView) convertView.findViewById(R.id.tv_flag);
            itemHolder.mTvUnit = (TextView) convertView.findViewById(R.id.tv_unit);
            itemHolder.mTvCount = (TextView) convertView.findViewById(R.id.tv_count);
            itemHolder.mTvTotal = (TextView) convertView.findViewById(R.id.tv_total);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (CartItemViewHolder) convertView.getTag();
        }
        final CartItem item = (CartItem) getItem(position);

        if (item.getGoodsDetail().getDefaultImage() != null) {
            ImageLoaderUtil.getInstance().displayImageView(item.getGoodsDetail().getDefaultImage(), itemHolder.mIvShoppingPic);
        }

        itemHolder.mTvShoppingDesc.setText(item.getGoodsDetail().getName());
        List<Map> specMap = item.getGoodsDetail().getSpecMap();
        if (specMap != null) {
            itemHolder.mTvFlag.setText("类型：" + specMap.get(0).get("v_val") + "颜色:" + specMap.get(1).get("v_val") + "规格" + specMap.get(2).get("v_val"));
        } else {
            itemHolder.mTvFlag.setText("规格：" + item.getGoodsDetail().getShortDesc());
        }
        itemHolder.mTvUnit.setText("￥ " + item.getGoodsDetail().getPrice());
        itemHolder.mTvCount.setText(item.getCount() + "");
        itemHolder.mTvTotal.setText((item.getGoodsDetail().getPrice() * item.getCount()) + "");

        return convertView;
    }

    class CartItemViewHolder {
        ImageView mIvShoppingPic;
        TextView mTvShoppingDesc;
        TextView mTvFlag;
        TextView mTvUnit;
        TextView mTvCount;
        TextView mTvTotal;
    }
}
