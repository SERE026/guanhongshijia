package com.wckj.gfsj.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.SubCategoryRequest;
import com.wckj.gfsj.Bean.SubCategoryResult;
import com.wckj.gfsj.Bean.entity.CategoryThree;
import com.wckj.gfsj.Bean.entity.CategoryTwo;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.StopViewPage;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.Fragment.Commodity_level_two_fragment;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 二级商品类型分类
 * acr
 */
public class CommodityLevelTwoActivity extends BaseNewActivity implements View.OnClickListener {

    private View view;
    private ListView lv_item;
    private StopViewPage svp_special;
    private CommonAdapter mlvAdapter;
    private FragmentAdapter mPageAdapter;
    private List<Fragment> pageList = new ArrayList<Fragment>();
    private int mLvPosition;
    private View titleView;
    private TitleRelativeLayout title_rl;
    private String id,category="";
    private SubCategoryResult json;

    @Override
    protected void init() {
         id = getIntent().getStringExtra("id");
        category = getIntent().getStringExtra("category");
        if(TextUtils.isEmpty(id)){
            OwerToastShow.show("该商品系列不存在");
            finish(); //不知道为什么这里finsh会导致首页fragment重叠
        }
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView =  inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        TextView tv_content_desc = (TextView) title_rl.childView.findViewById(R.id.tv_content_desc);
                tv_content_desc.setText( category);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_category_two, null);
        lv_item = (ListView) view.findViewById(R.id.lv_item);
        svp_special = (StopViewPage) view.findViewById(R.id.svp_special);
        json.getCategoryList().get(mLvPosition).setColorSelector(true);
        bindData();
        setListener();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        getCategorySub();
    }

    private void setListener() {
        //设置listview点击
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                json.getCategoryList().get(mLvPosition).setColorSelector(false);
                mLvPosition=position;
                json.getCategoryList().get(position).setColorSelector(true);
                mlvAdapter.notifyDataSetChanged();

                svp_special.setCurrentItem(position);
            }
        });
    }



    private void bindData() {
        initViewPage();
        if (mlvAdapter == null) {
            mlvAdapter = new CommonAdapter<CategoryTwo>(this, json.getCategoryList(), R.layout.item_lv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, CategoryTwo item, int position) {
                    helper.setText(R.id.tv_two_name, item.getTitle());

                    boolean colorSelector = item.isColorSelector();
                    if(colorSelector) {
                        helper.setTextColor(R.id.tv_two_name, getResources().getColor(R.color.color_121212));
                        helper.setBackgroundResource(R.id.tv_two_name, getResources().getColor(R.color.white));
                    }else {
                        helper.setTextColor(R.id.tv_two_name,getResources().getColor( R.color.color_bcbcbc));
                        helper.setBackgroundResource(R.id.tv_two_name,0);
                    }
                }
            };
            lv_item.setAdapter(mlvAdapter);
        } else {
            mlvAdapter.notifyDataSetChanged();
        }

    }

    /**
     * 初始化不能滑动viewpage
     */
    private void initViewPage() {
        if (mPageAdapter == null && pageList.isEmpty()) {
            for (int i = 0; i < json.getCategoryList().size(); i++) {
                // 添加子页
                Commodity_level_two_fragment fragment = new Commodity_level_two_fragment();
                Bundle bundle = new Bundle();
                //给一些参数
               bundle.putString("title",json.getCategoryList().get(i).getTitle());
                List<CategoryThree> childrenList = json.getCategoryList().get(i).getChildrenList();
                bundle.putSerializable("categoryThree",(ArrayList)childrenList);
                fragment.setArguments(bundle);
                pageList.add(fragment);
            }
            mPageAdapter = new FragmentAdapter(getSupportFragmentManager());
        }

        svp_special.setAdapter(mPageAdapter);

    }

    public void getCategorySub() {
        SubCategoryRequest request = new SubCategoryRequest();
        request.setId(Integer.parseInt(id));
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CATEGORY_SUB_URL, new ICallBack() {

            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 json =  JSON.parseObject(response, SubCategoryResult.class);
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });
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
