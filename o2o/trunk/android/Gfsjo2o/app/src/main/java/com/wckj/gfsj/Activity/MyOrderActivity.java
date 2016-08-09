package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.EvalOrderRequest;
import com.wckj.gfsj.Bean.EvalOrderResult;
import com.wckj.gfsj.Bean.QueryOrderRequest;
import com.wckj.gfsj.Bean.QueryOrderResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/25.
 */
public class MyOrderActivity extends BaseNewActivity implements View.OnClickListener {

    private static final String TAG = "MyOrderActivity";

    private TextView tv_go_back;
    private View view;

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_set_password, null);
        titleView.findViewById(R.id.tv_go_back).setOnClickListener(this);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_my_order, null);
        initView();
//        evalOrder(1000+"", 2, 3, 3, 0);
//        queryOrder(-1);
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    private void initView() {

    }

    /**
     * 评价订单
     * @param orderId      订单ID
     * @param sameStar     商品符合度(1~5)
     * @param speedStar    物流速度(1~5)
     * @param attitudeStar 配送员服务态度(1~5)
     * @param orderStatus  订单状态(-1—全部,0—待付款,1—待发货,2—待收货)
     */
    private void evalOrder(String orderId, int sameStar, int speedStar, int attitudeStar, int orderStatus) {
        EvalOrderRequest request = new EvalOrderRequest();
        request.setOrderId(orderId);
        request.setSameStar(sameStar);
        request.setSpeedStar(speedStar);
        request.setAttitudeStar(attitudeStar);
        request.setOrderStatus(orderStatus);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_EVAL_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                EvalOrderResult json = JSON.parseObject(response, EvalOrderResult.class);
                LogUtil.i(response);
            }
        });
    }

    /**
     * 查询订单
     * @param orderStatus 订单状态(-1—全部,0—待付款,1—待发货,2—待收货)
     */
    private void queryOrder(int orderStatus) {
        QueryOrderRequest request = new QueryOrderRequest();
        request.setOrderStatus(orderStatus);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.ORDER_LIST_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryOrderResult json = JSON.parseObject(response, QueryOrderResult.class);
                LogUtil.i(response);
            }
        });
    }
}
