package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.QueryCouponRequest;
import com.wckj.gfsj.Bean.QueryCouponResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import okhttp3.Call;

/**
 * Created by rayco on 2016/7/30.
 */
public class CouponActivity extends BaseNewActivity implements View.OnClickListener {

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
        view = inflater.inflate(R.layout.activity_coupon, null);
        initView();
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

//        queryCoupon(0, 0);
    }

    /**
     * 查询优惠券
     * @param status 状态(0-全部,1-未使用,2-已使用,3-已过期)
     * @param type   优惠券类型(0-全部,1-代金券,2-折扣券)
     */
    private void queryCoupon(int status, int type) {
        QueryCouponRequest request = new QueryCouponRequest();
        request.setStatus(status);
        request.setType(type);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.COUPON_QUERY_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryCouponResult json = JSON.parseObject(response, QueryCouponResult.class);
                LogUtil.i(response + "");
            }
        });
    }
}
