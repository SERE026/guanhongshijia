package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.AgencyFeeItemAdapter;
import com.wckj.gfsj.Bean.QueryAgencyFeeRequest;
import com.wckj.gfsj.Bean.QueryAgencyFeeResult;
import com.wckj.gfsj.Bean.entity.AgencyFeeItem;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by rayco on 16/7/25.
 */
public class MyBrokerageFragment extends Fragment implements View.OnClickListener {

    private TextView mTvMoney, mTvRecentlyBrokerage, mTvTotalBrokerage, mTvDataDate;
    private ListView mLvAgencyFeeItem;

    private AgencyFeeItemAdapter mAgencyFeeItemAdapter;

    List<AgencyFeeItem> mAgencyFeeItemList = new ArrayList<AgencyFeeItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_brokerage, null);

        mTvMoney = (TextView) view.findViewById(R.id.tv_money);
        mTvRecentlyBrokerage = (TextView) view.findViewById(R.id.tv_recently_brokerage);
        mTvTotalBrokerage = (TextView) view.findViewById(R.id.tv_total_brokerage);
        mTvDataDate = (TextView) view.findViewById(R.id.tv_data_date);

        mLvAgencyFeeItem = (ListView) view.findViewById(R.id.lv_agency_fee_item);

        mAgencyFeeItemAdapter = new AgencyFeeItemAdapter(getContext(), mAgencyFeeItemList);

        mLvAgencyFeeItem.setAdapter(mAgencyFeeItemAdapter);

        queryBrokerage();
        return view;
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 查询佣金
     */
    private void queryBrokerage() {
        QueryAgencyFeeRequest request = new QueryAgencyFeeRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.AGENCY_FEE_QUERY_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryAgencyFeeResult result = JSON.parseObject(response, QueryAgencyFeeResult.class);
                LogUtil.i(response);
                if (result.getResultCode() == 0) {
                    mTvMoney.setText(result.getCurrentMoney() + "元");
                    mTvRecentlyBrokerage.setText("最近佣金提成：" + result.getRecentMoney() + "元");
                    mTvTotalBrokerage.setText("累计已获佣金：" + result.getTotalMoney() + "元");
                    mTvDataDate.setText("数据截至：" + result.getDataDate());

                    if (result.getAgencyFeeItemList() != null && !result.getAgencyFeeItemList().isEmpty()) {
                        mAgencyFeeItemList.clear();
                        mAgencyFeeItemList.addAll(result.getAgencyFeeItemList());
                        mAgencyFeeItemAdapter.notifyDataSetChanged();
                    }

//                    for (int i = 0; i < 20; i++) {
//                        AgencyFeeItem item = new AgencyFeeItem();
//                        item.setId(i+"");
//                        item.setDate("2016-08-18");
//                        item.setOrderNo("20160818");
//                        item.setPrice(20000.00);
//                        item.setPercent("2%100");
//                        item.setAmount(20000.00);
//                        mAgencyFeeItemList.add(item);
//                    }
//                    mAgencyFeeItemAdapter.notifyDataSetChanged();
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
