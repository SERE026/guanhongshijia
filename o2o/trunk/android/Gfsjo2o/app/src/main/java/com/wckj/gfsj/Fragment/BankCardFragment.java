package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Bean.QueryCardRequest;
import com.wckj.gfsj.Bean.QueryCardResult;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;

import okhttp3.Call;

/**
 * Created by rayco on 16/7/25.
 */
public class BankCardFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank_card, null);
//        queryBankCard();
        return view;
    }

    @Override
    public void onClick(View view) {

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
                QueryCardResult json = JSON.parseObject(response, QueryCardResult.class);
                LogUtil.i(response);
            }
        });
    }
}
