package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CartItemAdapter;
import com.wckj.gfsj.Bean.QueryOrderRequest;
import com.wckj.gfsj.Bean.QueryOrderResult;
import com.wckj.gfsj.Bean.entity.CartItem;
import com.wckj.gfsj.Bean.entity.Order;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by rayco on 16/7/25.
 */
public class WaitReceiptFragment extends Fragment implements View.OnClickListener {

    private ListView mLvGoods;

    private CartItemAdapter mCartItemAdapter;

    private List<Order> mOrderList = new ArrayList<Order>();
    private List<CartItem> mCartItemList = new ArrayList<CartItem>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mCartItemAdapter = new CartItemAdapter(getContext(), mCartItemList);

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, null);
        mLvGoods = (ListView) view.findViewById(R.id.lv_goods);
        mLvGoods.setAdapter(mCartItemAdapter);

        queryOrder(2);
        return view;
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 查询订单
     * @param orderStatus 订单状态(-1—全部,0—待付款,1—待发货,2—待收货)
     */
    private void queryOrder(int orderStatus) {
        final QueryOrderRequest request = new QueryOrderRequest();
        request.setOrderStatus(orderStatus);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_LIST_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryOrderResult json = JSON.parseObject(response, QueryOrderResult.class);
                int resultCode = json.getResultCode();
                if (resultCode == 0) {
                    mOrderList = json.getOrderList();
                    mCartItemList.clear();

                    for (Order order : mOrderList) {
                        CartItem item = new CartItem();
                        item.setId("-1");
                        mCartItemList.add(item);
                        mCartItemList.addAll(order.getCartItemList());
                    }
                    mCartItemAdapter.notifyDataSetChanged();
                }
                LogUtil.i(response);
            }
        });
    }
}
