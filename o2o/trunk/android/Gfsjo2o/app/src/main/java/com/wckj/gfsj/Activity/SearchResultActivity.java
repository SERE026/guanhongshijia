package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.QueryPersonalRequest;
import com.wckj.gfsj.Bean.QueryPersonalResult;
import com.wckj.gfsj.Bean.entity.GoodsSummary;
import com.wckj.gfsj.Bean.entity.Personal;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
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
 * Created by rayco on 2016/8/22.
 */
public class SearchResultActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;
    private List<GoodsSummary> mGoodsList = new ArrayList<GoodsSummary>();

    private Intent mIntent;

    @Override
    protected void init() {
        mIntent = getIntent();
        mGoodsList = (ArrayList<GoodsSummary>) mIntent.getSerializableExtra("goodsList");
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_public_title_main, null);
        mRlTitle = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        mRlTitle.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        TextView tv_content_desc = (TextView) mRlTitle.childView.findViewById(R.id.tv_content_desc);
        tv_content_desc.setText("搜索结果");
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_three, null);
        gv_commodity_three = (GridView) view.findViewById(R.id.gv_commodity_three);
        bindData();
        setListener();
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
        switch (v.getId()) {
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }

    private void bindData() {
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<GoodsSummary>(view.getContext(), mGoodsList, R.layout.item_gv_commodity_three) {
                @Override
                public void convert(ViewHolder helper, GoodsSummary item, int position) {
                    helper.setText(R.id.tv_title_desc, item.getTitle());
                    helper.setImageByUrl(R.id.iv_shopping_pic, item.getMainPicUrl());
                    helper.setText(R.id.tv_name, "￥" + item.getPrice());
                }
            };
            gv_commodity_three.setAdapter(mlvAdapter);
        } else {
            mlvAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        gv_commodity_three.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CommoditydetailsActivity.class);
                GoodsSummary goods = (GoodsSummary) parent.getItemAtPosition(position);
                intent.putExtra("goodsId", goods.getId());
                startActivity(intent);
            }
        });
    }
}
