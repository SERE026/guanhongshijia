package com.wckj.gfsj.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_three;
import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 商品三级列表
 */
public class CommodityLevelThreeActivity extends BaseNewActivity implements View.OnClickListener {
    private TextView tv_time;
    private View view;
    private ArrayList<Commodity_level_three> mList;
    private GridView gv_commodity_three;
    private CommonAdapter mlvAdapter;

    @Override
    protected void init() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_go_back, null);
        titleView. findViewById(R.id.rl_brand).setVisibility(View.VISIBLE);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        tv_time = (TextView) titleView.findViewById(R.id.tv_time);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_three, null);
        gv_commodity_three = (GridView) view.findViewById(R.id.gv_commodity_three);
        bindData();
        return view;
    }

    private void bindData() {
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<Commodity_level_three>(this,mList,R.layout.item_gv_commodity_three) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_three item, int position) {
                    helper.setText(R.id.tv_title_desc,"凳子");


                }
            };
            gv_commodity_three.setAdapter(mlvAdapter);
        }else {
            mlvAdapter.notifyDataSetChanged();
        }

    }


    @Override
    protected void refreshOrLoadView() {

    }
    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new Commodity_level_three());
        }
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void  onMainTimeEvent(TimeEvent time){
        if(tv_time!=null){
            tv_time.setText(time.getTime());
        }
    }
}
