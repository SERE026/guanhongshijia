package com.wckj.gfsj.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.CartListRequest;
import com.wckj.gfsj.Bean.CartListResult;
import com.wckj.gfsj.Bean.CreateOrderRequest;
import com.wckj.gfsj.Bean.CreateOrderResult;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.List;

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

    @Override
    protected void init() {
        loadPage.iv_networktext.setImageResource(R.drawable.icon_big_cart);
        loadPage.textView1.setText("你还没有相关订单");
        loadPage.textView2.setText("快去商品购物页选择其他商品吧！！！");
//        List<CartItem> list = new ArrayList<CartItem>();
//        createOrder(list);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_shopping_cart, null);
        lv_shopping = (ListView) view.findViewById(R.id.lv_shopping);
        binData();
        return view;
    }

    private void binData() {
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<CartItem>(view.getContext(), mList, R.layout.item_shopping_cart) {
                @Override
                public void convert(ViewHolder helper, CartItem item, int position) {


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
               showPageState(checkData(mList));
           }
       });
    }

    /**
     * 创建订单
     * @param cartItemList 购物车商品列表
     */
    private void createOrder(List<CartItem> cartItemList) {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCartItemList(cartItemList);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_CREATE_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                CreateOrderResult result = JSON.parseObject(response, CreateOrderResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    OwerToastShow.show("创建成功");
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {

    }


}
