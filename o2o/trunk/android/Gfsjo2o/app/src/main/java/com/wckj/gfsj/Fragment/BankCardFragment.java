package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentFrameLayout;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.BindBankCardctivity;
import com.wckj.gfsj.Adapter.BankCardAdapter;
import com.wckj.gfsj.Bean.QueryCardRequest;
import com.wckj.gfsj.Bean.QueryCardResult;
import com.wckj.gfsj.Bean.entity.Card;
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
public class BankCardFragment extends Fragment implements View.OnClickListener {

    private PercentFrameLayout mFlContent;
    private ListView mLvBankCard;
    private PercentRelativeLayout mRlNotBind;
    private TextView mTvNotBind, mTvGoToBind;

    private BankCardAdapter mBankCardAdapter;

    List<Card> mCardList = new ArrayList<Card>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_card, null);

        mFlContent = (PercentFrameLayout) view.findViewById(R.id.fl_content);
        mLvBankCard = (ListView) view.findViewById(R.id.lv_bank_card);
        mRlNotBind = (PercentRelativeLayout) view.findViewById(R.id.rl_not_bind);
        mTvNotBind = (TextView) view.findViewById(R.id.tv_not_bind);
        mTvGoToBind = (TextView) view.findViewById(R.id.tv_go_to_bind);
        mTvGoToBind.setOnClickListener(this);

        mBankCardAdapter = new BankCardAdapter(getContext(), mCardList);

        mLvBankCard.setAdapter(mBankCardAdapter);

        queryBankCard();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_to_bind:
                Intent intent = new Intent(view.getContext(), BindBankCardctivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 查询银行卡
     */
    private void queryBankCard() {
        QueryCardRequest request = new QueryCardRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.BANK_CARD_QUERY_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                QueryCardResult result = JSON.parseObject(response, QueryCardResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    if (result.getCardList() != null && !result.getCardList().isEmpty()) {
                        mLvBankCard.setVisibility(View.VISIBLE);
                        mRlNotBind.setVisibility(View.GONE);

                        mCardList.clear();
                        mCardList.addAll(result.getCardList());
                        mBankCardAdapter.notifyDataSetChanged();

//                        for (int i = 0; i < 30; i++) {
//                            Card item = new Card();
//                            item.setBankName("中国农业银行");
//                            item.setCardNo("6228480606705173777");
//                            item.setStatus("正常使用");
//                            item.setType("储蓄卡");
//                            mCardList.add(item);
//                        }
//                        mBankCardAdapter.notifyDataSetChanged();
                    } else {
                        mLvBankCard.setVisibility(View.GONE);
                        mRlNotBind.setVisibility(View.VISIBLE);
                    }
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
