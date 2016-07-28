package com.wckj.gfsj.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by 小爱爱 on 2016/7/18.
 */
public class Shopping_cart_fragment extends BaseNewFragment implements View.OnClickListener {
    private TextView tv_time, tv_content_desc;
    private View view;
    private ListView lv_shopping;
    private CommonAdapter mlvAdapter;
    private ArrayList<Commodity_level_details> mList;

    @Override
    protected void init() {
        EventBus.getDefault().register(this);
        loadPage.iv_networktext.setImageResource(R.drawable.icon_big_cart);
        loadPage.textView1.setText("你还没有相关订单");
        loadPage.textView2.setText("快去商品购物页选择其他商品吧！！！");
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
//        View titleView = inflater.inflate(R.layout.layout_title_main_go_back, null);
//        titleView.findViewById(R.id.tv_go_back).setOnClickListener(this);
//        tv_time = (TextView) titleView.findViewById(R.id.tv_time);
//        titleView.findViewById(R.id.tv_content_desc).setVisibility(View.GONE);
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_shopping_cart, null);
        lv_shopping = (ListView) view.findViewById(R.id.lv_shopping);
        binData();
        return view;
    }

    private void binData() {
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<Commodity_level_details>(view.getContext(), mList, R.layout.item_shopping_cart) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_details item, int position) {


                }
            };
            lv_shopping.setAdapter(mlvAdapter);
        } else {
            mlvAdapter.notifyDataSetChanged();
        }
    }

    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new Commodity_level_details());
        }

        showPageState(FrameLoadLayout.LoadResult.empty);
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {

    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onMainTimeEvent(TimeEvent time) {
        if (tv_time != null) {
            tv_time.setText(time.getTime());
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
