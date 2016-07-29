package com.wckj.gfsj.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_two;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.StopViewPage;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.Fragment.Commodity_level_two_fragment;
import com.wckj.gfsj.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 二级商品类型分类
 * acr
 */
public class CommodityLevelTwoActivity extends BaseNewActivity implements View.OnClickListener {

    private View view;
    private ListView lv_item;
    private StopViewPage svp_special;
    private ArrayList<Commodity_level_two> mList;
    private CommonAdapter mlvAdapter;
    private FragmentAdapter mPageAdapter;
    private List<Fragment> pageList = new ArrayList<Fragment>();
    private int mLvPosition;
    private View titleView;
    private TitleRelativeLayout title_rl;


    @Override
    protected void init() {
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView =  inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_category_two, null);
        lv_item = (ListView) view.findViewById(R.id.lv_item);
        svp_special = (StopViewPage) view.findViewById(R.id.svp_special);
        bindData();
        setListener();
        return view;
    }

    private void setListener() {
        //设置listview点击
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mList.get(mLvPosition).setColorSelector(false);
                mLvPosition=position;
                mList.get(position).setColorSelector(true);
                mlvAdapter.notifyDataSetChanged();

                svp_special.setCurrentItem(position);
            }
        });
    }

    /**
     * 初始化不能滑动viewpage
     */
    private void initData() {
        if (mPageAdapter == null && pageList.isEmpty()) {
            for (int i = 0; i < mList.size(); i++) {
                // 添加子页
                Commodity_level_two_fragment fragment = new Commodity_level_two_fragment();
                Bundle bundle = new Bundle();
                //给一些参数
                bundle.putString("ceshi",i+"凳子");
                fragment.setArguments(bundle);
                pageList.add(fragment);
            }
            mPageAdapter = new FragmentAdapter(getSupportFragmentManager());
        }

        svp_special.setAdapter(mPageAdapter);

    }

    private void bindData() {
        initData();
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<Commodity_level_two>(this, mList, R.layout.item_lv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_two item, int position) {
                    helper.setText(R.id.tv_two_name, "凳子");
                    boolean colorSelector = item.isColorSelector();
                    if(colorSelector) {
                        helper.setBackgroundResource(R.id.tv_two_name, getResources().getColor(R.color.white));
                    }else {
                        helper.setBackgroundResource(R.id.tv_two_name,0);
                    }
                }
            };
            lv_item.setAdapter(mlvAdapter);
        } else {
            mlvAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mList.add(new Commodity_level_two());

        }
        mList.get(0).setColorSelector(true);
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
        title_rl. clearRegister();
    }



    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return pageList.get(position);
        }

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 得到缓存的fragment
            Fragment fragment = (Fragment) super.instantiateItem(container,
                    position);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }
    }
}
