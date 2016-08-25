package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.OrderConfirmOneActivity;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.CartListRequest;
import com.wckj.gfsj.Bean.CartListResult;
import com.wckj.gfsj.Bean.DelCartRequest;
import com.wckj.gfsj.Bean.DelCartResult;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Shopping_cart_fragment extends BaseNewFragment implements View.OnClickListener {
    private TextView tv_time, tv_content_desc;
    private View view;
    private ListView lv_shopping;
    private CommonAdapter mlvAdapter;
    private CartListResult mJson;
    private List<CartItem> mList;
    private CheckBox cb_big_all;
    private TextView tv_check_num;
    private int count;
    private Button bt_pay;
    private List<CartItem> mSelectedList = new ArrayList<CartItem>();

    @Override
    protected void init() {
        loadPage.iv_networktext.setImageResource(R.drawable.icon_big_cart);
        loadPage.textView1.setText("你还没有相关订单");
        loadPage.textView2.setText("快去商品购物页选择其他商品吧！！！");
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_shopping_cart, null);
        lv_shopping = (ListView) view.findViewById(R.id.lv_shopping);
        cb_big_all = (CheckBox) view.findViewById(R.id.cb_big_all);
        tv_check_num = (TextView) view.findViewById(R.id.tv_check_num);
        bt_pay = (Button) view.findViewById(R.id.bt_pay);
        

        cb_big_all.setOnClickListener(this);
        bt_pay.setOnClickListener(this);
        binData();
        return view;
    }

    private void binData() {
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<CartItem>(view.getContext(), mList, R.layout.item_shopping_cart) {
                @Override
                public void convert(ViewHolder helper, final CartItem item, final int position) {
                    helper.setImageByUrl(R.id.iv_shopping_pic,item.getGoodsDetail().getDefaultImage());
                    helper.setText(R.id.tv_shopping_desc,item.getGoodsDetail().getName());
                    List<Map> specMap = item.getGoodsDetail().getSpecMap();
                    if(specMap!=null){
                        helper.setText(R.id.tv_flag,"类型："+specMap.get(0).get("v_val")+"颜色:"+specMap.get(1).get("v_val")+"规格"+specMap.get(2).get("v_val"));
                    }else {
                        helper.setText(R.id.tv_flag,"规格："+item.getGoodsDetail().getShortDesc());
                    }
                    helper.setText(R.id.tv_cart_price,"￥ "+item.getGoodsDetail().getPrice());
                    helper.setText(R.id.edt,item.getCount()+"");
                    final CheckBox cb_big = helper.getView(R.id.cb_big);
                    cb_big.setChecked(item.isCheck());
                    cb_big.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (cb_big.isChecked()) {
                                count++;
                                mSelectedList.add(item);
                            } else {
                                count--;
                                mSelectedList.remove(item);
                            }
                            item.setCheck(cb_big.isChecked());
                            tv_check_num.setText("已选中"+count+"件商品");
                        }
                    });

                    Button bt_delete = helper.getView(R.id.bt_delete);
                    bt_delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mList.remove(position);
                            deleCart(item.getGoodsDetail().getId());
                            notifyDataSetChanged();
                        }
                    });

                }
            };
            lv_shopping.setAdapter(mlvAdapter);
        } else {
            mlvAdapter.notifyDataSetChanged();
        }
    }

    protected void load() {

        getCartList();

    }

    //获取购物车列表
    private void getCartList(){
       CartListRequest request = new CartListRequest();
       HttpUtils.getInstance().asyncPost(request, GlobalUtils.CART_LIST_URL, new ICallBack() {
           @Override
           public void onError(Call call, Exception e) {
               showPageState(FrameLoadLayout.LoadResult.error);
           }

           @Override
           public void onSuccess(String response) {

                mJson =  JSON.parseObject(response, CartListResult.class);
               mList = mJson.getCart().getItemList();
               LogUtil.d("mList.size="+mList.size());
               showPageState(checkData(mList));
           }
       });
    }


    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.cb_big_all:
                boolean checked = cb_big_all.isChecked();
                   for (CartItem mitem: mList) {
                       mitem.setCheck(checked);
                   }
                if(checked) {
                   count = mList.size();
                   mSelectedList.clear();
                   mSelectedList.addAll(mList);
                } else {
                   count = 0;
                   mSelectedList.clear();
                }
                mlvAdapter.notifyDataSetChanged();
                tv_check_num.setText("已选中"+count+"件商品");
                break;
            case R.id.bt_pay:
                if (mSelectedList != null && !mSelectedList.isEmpty()) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), OrderConfirmOneActivity.class);
                    intent.putExtra("cartItemList", (ArrayList<CartItem>)mSelectedList);
                    startActivity(intent);
                }
                break;
        }
    }

    /**
     * 删除购物车
     */
    private void deleCart(String goodsId) {
        DelCartRequest request = new DelCartRequest();

        request.setGoodsId(goodsId);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CART_DEL_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                OwerToastShow.show("购物车删除失败");
            }

            @Override
            public void onSuccess(String response) {
                DelCartResult json = JSON.parseObject(response, DelCartResult.class);
                if(json.getResultCode()==0){
                    OwerToastShow.show("购物车删除成功");
                }else {
                    OwerToastShow.show("购物车删除失败");
                }
            }
        });
    }

}
