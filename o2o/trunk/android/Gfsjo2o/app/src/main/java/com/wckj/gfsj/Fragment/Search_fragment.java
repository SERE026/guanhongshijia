package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.SearchResultActivity;
import com.wckj.gfsj.Bean.SearchRequest;
import com.wckj.gfsj.Bean.SearchResult;
import com.wckj.gfsj.Bean.entity.GoodsSummary;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/18.
 * 搜索
 */
public class Search_fragment extends Fragment implements View.OnClickListener {
    private View mView;

    private EditText mEtInput;
    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn0, mBtnDelete,
            mBtnQ, mBtnW, mBtnE, mBtnR, mBtnT, mBtnY, mBtnU, mBtnI, mBtnO, mBtnP, mBtnClear,
            mBtnA, mBtnS, mBtnD, mBtnF, mBtnG, mBtnH, mBtnJ, mBtnK, mBtnL,
            mBtnZ, mBtnX, mBtnC, mBtnV, mBtnB, mBtnN, mBtnM;
    private ImageView mIvSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_search, null);
        initView();
        return mView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search:
                String text = mEtInput.getText().toString().trim();
                if (!text.isEmpty()) {
                    search(text);
                }
                break;
            case R.id.btn_1:
                mEtInput.setText(mEtInput.getText()+"1");
                break;
            case R.id.btn_2:
                mEtInput.setText(mEtInput.getText()+"2");
                break;
            case R.id.btn_3:
                mEtInput.setText(mEtInput.getText()+"3");
                break;
            case R.id.btn_4:
                mEtInput.setText(mEtInput.getText()+"4");
                break;
            case R.id.btn_5:
                mEtInput.setText(mEtInput.getText()+"5");
                break;
            case R.id.btn_6:
                mEtInput.setText(mEtInput.getText()+"6");
                break;
            case R.id.btn_7:
                mEtInput.setText(mEtInput.getText()+"7");
                break;
            case R.id.btn_8:
                mEtInput.setText(mEtInput.getText()+"8");
                break;
            case R.id.btn_9:
                mEtInput.setText(mEtInput.getText()+"9");
                break;
            case R.id.btn_0:
                mEtInput.setText(mEtInput.getText()+"0");
                break;
            case R.id.btn_delete:
                String str = mEtInput.getText().toString().trim();
                if (str.length() >= 2) {
                    mEtInput.setText(str.substring(0, str.length()-1));
                } else {
                    mEtInput.setText("");
                }
                break;
            case R.id.btn_q:
                mEtInput.setText(mEtInput.getText()+"Q");
                break;
            case R.id.btn_w:
                mEtInput.setText(mEtInput.getText()+"W");
                break;
            case R.id.btn_e:
                mEtInput.setText(mEtInput.getText()+"E");
                break;
            case R.id.btn_r:
                mEtInput.setText(mEtInput.getText()+"R");
                break;
            case R.id.btn_t:
                mEtInput.setText(mEtInput.getText()+"T");
                break;
            case R.id.btn_y:
                mEtInput.setText(mEtInput.getText()+"Y");
                break;
            case R.id.btn_u:
                mEtInput.setText(mEtInput.getText()+"U");
                break;
            case R.id.btn_i:
                mEtInput.setText(mEtInput.getText()+"I");
                break;
            case R.id.btn_o:
                mEtInput.setText(mEtInput.getText()+"O");
                break;
            case R.id.btn_p:
                mEtInput.setText(mEtInput.getText()+"P");
                break;
            case R.id.btn_clear:
                mEtInput.setText("");
                break;
            case R.id.btn_a:
                mEtInput.setText(mEtInput.getText()+"A");
                break;
            case R.id.btn_s:
                mEtInput.setText(mEtInput.getText()+"S");
                break;
            case R.id.btn_d:
                mEtInput.setText(mEtInput.getText()+"D");
                break;
            case R.id.btn_f:
                mEtInput.setText(mEtInput.getText()+"F");
                break;
            case R.id.btn_g:
                mEtInput.setText(mEtInput.getText()+"G");
                break;
            case R.id.btn_h:
                mEtInput.setText(mEtInput.getText()+"H");
                break;
            case R.id.btn_j:
                mEtInput.setText(mEtInput.getText()+"J");
                break;
            case R.id.btn_k:
                mEtInput.setText(mEtInput.getText()+"K");
                break;
            case R.id.btn_l:
                mEtInput.setText(mEtInput.getText()+"L");
                break;
            case R.id.btn_z:
                mEtInput.setText(mEtInput.getText()+"Z");
                break;
            case R.id.btn_x:
                mEtInput.setText(mEtInput.getText()+"X");
                break;
            case R.id.btn_c:
                mEtInput.setText(mEtInput.getText()+"C");
                break;
            case R.id.btn_v:
                mEtInput.setText(mEtInput.getText()+"V");
                break;
            case R.id.btn_b:
                mEtInput.setText(mEtInput.getText()+"B");
                break;
            case R.id.btn_n:
                mEtInput.setText(mEtInput.getText()+"N");
                break;
            case R.id.btn_m:
                mEtInput.setText(mEtInput.getText()+"M");
                break;
            default:
                break;
        }
        mEtInput.setSelection(mEtInput.getText().length());
    }

    private void initView() {
        mEtInput = (EditText) mView.findViewById(R.id.et_input);
        mIvSearch = (ImageView) mView.findViewById(R.id.iv_search);

        mBtn1 = (Button) mView.findViewById(R.id.btn_1);
        mBtn2 = (Button) mView.findViewById(R.id.btn_2);
        mBtn3 = (Button) mView.findViewById(R.id.btn_3);
        mBtn4 = (Button) mView.findViewById(R.id.btn_4);
        mBtn5 = (Button) mView.findViewById(R.id.btn_5);
        mBtn6 = (Button) mView.findViewById(R.id.btn_6);
        mBtn7 = (Button) mView.findViewById(R.id.btn_7);
        mBtn8 = (Button) mView.findViewById(R.id.btn_8);
        mBtn9 = (Button) mView.findViewById(R.id.btn_9);
        mBtn0 = (Button) mView.findViewById(R.id.btn_0);
        mBtnDelete = (Button) mView.findViewById(R.id.btn_delete);

        mBtnQ = (Button) mView.findViewById(R.id.btn_q);
        mBtnW = (Button) mView.findViewById(R.id.btn_w);
        mBtnE = (Button) mView.findViewById(R.id.btn_e);
        mBtnR = (Button) mView.findViewById(R.id.btn_r);
        mBtnT = (Button) mView.findViewById(R.id.btn_t);
        mBtnY = (Button) mView.findViewById(R.id.btn_y);
        mBtnU = (Button) mView.findViewById(R.id.btn_u);
        mBtnI = (Button) mView.findViewById(R.id.btn_i);
        mBtnO = (Button) mView.findViewById(R.id.btn_o);
        mBtnP = (Button) mView.findViewById(R.id.btn_p);
        mBtnClear = (Button) mView.findViewById(R.id.btn_clear);

        mBtnA = (Button) mView.findViewById(R.id.btn_a);
        mBtnS = (Button) mView.findViewById(R.id.btn_s);
        mBtnD = (Button) mView.findViewById(R.id.btn_d);
        mBtnF = (Button) mView.findViewById(R.id.btn_f);
        mBtnG = (Button) mView.findViewById(R.id.btn_g);
        mBtnH = (Button) mView.findViewById(R.id.btn_h);
        mBtnJ = (Button) mView.findViewById(R.id.btn_j);
        mBtnK = (Button) mView.findViewById(R.id.btn_k);
        mBtnL = (Button) mView.findViewById(R.id.btn_l);

        mBtnZ = (Button) mView.findViewById(R.id.btn_z);
        mBtnX = (Button) mView.findViewById(R.id.btn_x);
        mBtnC = (Button) mView.findViewById(R.id.btn_c);
        mBtnV = (Button) mView.findViewById(R.id.btn_v);
        mBtnB = (Button) mView.findViewById(R.id.btn_b);
        mBtnN = (Button) mView.findViewById(R.id.btn_n);
        mBtnM = (Button) mView.findViewById(R.id.btn_m);

        mIvSearch.setOnClickListener(this);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtn0.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

        mBtnQ.setOnClickListener(this);
        mBtnW.setOnClickListener(this);
        mBtnE.setOnClickListener(this);
        mBtnR.setOnClickListener(this);
        mBtnT.setOnClickListener(this);
        mBtnY.setOnClickListener(this);
        mBtnU.setOnClickListener(this);
        mBtnI.setOnClickListener(this);
        mBtnO.setOnClickListener(this);
        mBtnP.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

        mBtnA.setOnClickListener(this);
        mBtnS.setOnClickListener(this);
        mBtnD.setOnClickListener(this);
        mBtnF.setOnClickListener(this);
        mBtnG.setOnClickListener(this);
        mBtnH.setOnClickListener(this);
        mBtnJ.setOnClickListener(this);
        mBtnK.setOnClickListener(this);
        mBtnL.setOnClickListener(this);

        mBtnZ.setOnClickListener(this);
        mBtnX.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnV.setOnClickListener(this);
        mBtnB.setOnClickListener(this);
        mBtnN.setOnClickListener(this);
        mBtnM.setOnClickListener(this);
    }

    /**
     * 搜索
     *
     * @param keyword 关键字
     */
    private void search(String keyword) {
        SearchRequest request = new SearchRequest();
        request.setPageSize(100);
        request.setKeyword(keyword);
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_SEARCH_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                SearchResult result = JSON.parseObject(response, SearchResult.class);
                LogUtil.i(response);

                if (result.getResultCode() == 0) {
                    ArrayList<GoodsSummary> goodsSummaryList = (ArrayList<GoodsSummary>)result.getGoodsSummaryList();
                    Intent intent = new Intent();
                    intent.putExtra("goodsList", goodsSummaryList);
                    intent.setClass(getContext(), SearchResultActivity.class);
                    startActivity(intent);
                } else {
                    OwerToastShow.show(result.getMessage());
                }
            }
        });
    }
}
