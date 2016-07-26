package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * 购物车页面
 */
public class ShoppingCartActivity extends BaseNewActivity implements View.OnClickListener {
    private TextView tv_time;
    private View view;
    private ListView lv_shopping;
    private CommonAdapter mlvAdapter;
    private ArrayList<Commodity_level_details> mList;

    @Override
    protected void init() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_go_back, null);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        tv_time = (TextView) titleView.findViewById(R.id.tv_time);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_shopping_cart, null);
        lv_shopping = (ListView) view.findViewById(R.id.lv_shopping);
        binData();
        return view;
    }

    private void binData() {
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<Commodity_level_details>(this,mList,R.layout.item_shopping_cart) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_details item, int position) {


                }
            };
            lv_shopping.setAdapter(mlvAdapter);
        }else {
            mlvAdapter.notifyDataSetChanged();
        }
    }
    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new Commodity_level_details());
        }

        showPageState(FrameLoadLayout.LoadResult.success);
    }
    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {

    }
}
