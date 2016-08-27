package com.wckj.gfsj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.UpdateOrderRequest;
import com.wckj.gfsj.Bean.UpdateOrderResult;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;
import com.wckj.gfsj.Utils.TimeUtils;

import java.util.List;

import okhttp3.Call;

/**
 * Created by rayco on 2016/8/11.
 */
public class CartItemAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private List<CartItem> mCartItemList;
    private int operateIndex;

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
                    itemHolder.mTvOperate = (TextView) convertView.findViewById(R.id.tv_operate);
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
                        itemHolder.mTvOperate = (TextView) convertView.findViewById(R.id.tv_operate);
                        convertView.setTag(itemHolder);
                    }
                }
                CartItem item = (CartItem) getItem(position);

                itemHolder.mTvGoodsName.setText(item.getGoodsDetail().getName());
                itemHolder.mTvUserName.setText(AppApplication.loginResult.getLoginName());
                itemHolder.mTvMoney.setText(String.valueOf(item.getGoodsDetail().getPrice()));
                itemHolder.mTvStatus.setText(item.getGoodsDetail().getType());
                itemHolder.mTvOperate.setText("确认收货");
                itemHolder.mTvOperate.setTag(position);
                itemHolder.mTvOperate.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        int pos = (int)view.getTag();
        operateIndex = pos;
        String orderId = "";
        while (pos > 0) {
            if (mCartItemList.get(pos).getId().equals("-1")) {
                orderId = mCartItemList.get(pos).getGoodsDetail().getId();
                break;
            }
            pos--;
        }
        updateOrder(orderId, 2);
    }

    /**
     * 确认收货
     * @param orderId     订单号
     * @param orderStatus 订单状态
     */
    private void updateOrder(String orderId, int orderStatus) {
        UpdateOrderRequest request = new UpdateOrderRequest();
        request.setOrderId(orderId);
        request.setOrderStatus(orderStatus);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_UPDATE_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                UpdateOrderResult result = JSON.parseObject(response, UpdateOrderResult.class);
                LogUtil.i(response);
                int resultCode = result.getResultCode();
                if (resultCode == 0) {
                    OwerToastShow.show("已确认收货");
                    mCartItemList.get(operateIndex).getGoodsDetail().setType("已收货");
                    notifyDataSetChanged();
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }

    class CartItemViewHolder {
        ImageView mIvGoodsPic;
        TextView mTvGoodsName;
        TextView mTvUserName;
        TextView mTvMoney;
        TextView mTvStatus;
        TextView mTvOperate;
    }

    class CartItemHeadViewHolder {
        TextView mTvDate;
        TextView mTvOrderNum;
    }
}
