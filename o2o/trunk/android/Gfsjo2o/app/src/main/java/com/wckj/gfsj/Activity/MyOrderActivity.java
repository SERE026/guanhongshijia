package com.wckj.gfsj.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.EvalOrderRequest;
import com.wckj.gfsj.Bean.EvalOrderResult;
import com.wckj.gfsj.Bean.QueryOrderRequest;
import com.wckj.gfsj.Bean.QueryOrderResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.Fragment.AllOrderFragment;
import com.wckj.gfsj.Fragment.WaitEvaluateFragment;
import com.wckj.gfsj.Fragment.WaitPayFragment;
import com.wckj.gfsj.Fragment.WaitReceiptFragment;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/25.
 */
public class MyOrderActivity extends BaseNewActivity implements View.OnClickListener {

    private static final String TAG = "MyOrderActivity";

    private TextView tv_go_back;
    private View view;
    private ViewPager mOrderViewPager;

    private FragmentAdapter adapter;

    private List<Fragment> pageList = new ArrayList<Fragment>();

    private TextView[] textViews = new TextView[4];

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
        mOrderViewPager.setCurrentItem(0);
        textViews[0].setTextColor(getResources().getColor(R.color.color_d77f18));
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
            case R.id.tv_all_order:
                mOrderViewPager.setCurrentItem(0);
                break;
            case R.id.tv_wait_pay:
                mOrderViewPager.setCurrentItem(1);
                break;
            case R.id.tv_wait_receipt:
                mOrderViewPager.setCurrentItem(2);
                break;
            case R.id.tv_wait_evaluate:
                mOrderViewPager.setCurrentItem(3);
                break;
        }
    }

    private void initView() {

        textViews[0] = (TextView) view.findViewById(R.id.tv_all_order);
        textViews[1] = (TextView) view.findViewById(R.id.tv_wait_pay);
        textViews[2] = (TextView) view.findViewById(R.id.tv_wait_receipt);
        textViews[3] = (TextView) view.findViewById(R.id.tv_wait_evaluate);
        for (int i = 0; i < 4; i++) {
            textViews[i].setOnClickListener(this);
        }

        if (mOrderViewPager == null) {
            mOrderViewPager = (ViewPager) view.findViewById(R.id.vp_order);
        }

        if (adapter == null && pageList.isEmpty()) {
            // 添加子页
            pageList.add(new AllOrderFragment());
            pageList.add(new WaitPayFragment());
            pageList.add(new WaitReceiptFragment());
            pageList.add(new WaitEvaluateFragment());
            adapter = new FragmentAdapter(getSupportFragmentManager());
        }

        mOrderViewPager.setAdapter(adapter);

        mOrderViewPager.setOffscreenPageLimit(3);
        mOrderViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 4; i++) {
                    if (i != position) {
                        textViews[i].setTextColor(getResources().getColor(R.color.color_202020));
                    } else {
                        textViews[position].setTextColor(getResources().getColor(R.color.color_d77f18));
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
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

    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageList.get(position);
        }

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }
    }
}
