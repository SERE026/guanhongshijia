package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.wckj.gfsj.Adapter.CommoditydetailsAdapter;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * 商品详情信息展示付款
 */
public class CommoditydetailsActivity extends BaseNewActivity implements View.OnClickListener{
    private Button bt_buy;
    private ViewPager vp_commodity_pic;
    private ArrayList<Commodity_level_details> mList=new ArrayList<>();
    private TitleRelativeLayout title_rl;

    @Override
    protected void init() {
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        title_rl.childView . findViewById(R.id.tv_content_desc).setVisibility(View.GONE);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        View view = inflater.inflate(R.layout.activity_commodity_details, null);
        bt_buy = (Button) view.findViewById(R.id.bt_buy);
        bt_buy.setOnClickListener(this);
        vp_commodity_pic = (ViewPager) view.findViewById(R.id.vp_commodity_pic);
        bindViewPage();//绑定viewpage
        return view;
    }

    private void bindViewPage() {
        for (int i = 0; i <5 ; i++) {
            mList.add(new Commodity_level_details());
        }
        vp_commodity_pic.setAdapter(new CommoditydetailsAdapter(mList,this));
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
            case R.id.bt_buy:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl. clearRegister();
    }
}
