package com.wckj.gfsj.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.StopViewPage;
import com.wckj.gfsj.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小爱爱 on 2016/7/15.
 */
public class Main_fragment extends Fragment implements View.OnClickListener {
    private TextView tv_main,tv_main_classification,tv_main_recommend;
    private View view;
    private StopViewPage svp_context;
    private List<Fragment> pageList = new ArrayList<Fragment>();
    private FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, null);
        initView();
        initData();
        return view;

    }

    private void initData() {
        if (adapter == null && pageList.isEmpty()) {
            // 添加子页
            pageList.add(new Main_main_fragment());
            pageList.add(new Main_classification_fragment());
            pageList.add(new Main_recommend_fragment());
            adapter = new FragmentAdapter(getChildFragmentManager());
        }

        svp_context.setAdapter(adapter);

    }

    private void initView() {
        svp_context =  (StopViewPage) view.findViewById(R.id.svp_context);
        tv_main = (TextView) view.findViewById(R.id.tv_main);
        tv_main_classification = (TextView) view.findViewById(R.id.tv_main_classification);
        tv_main_recommend = (TextView)view. findViewById(R.id.tv_main_recommend);
        tv_main.setOnClickListener(this);
        tv_main_classification.setOnClickListener(this);
        tv_main_recommend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_main://主页
                setMainColor(R.id.tv_main);
                svp_context.setCurrentItem(0);
                break;
            case R.id.tv_main_classification://分类
                setMainColor(R.id.tv_main_classification);
                svp_context.setCurrentItem(1);
                break;
            case R.id.tv_main_recommend://推荐
                setMainColor(R.id.tv_main_recommend);
                svp_context.setCurrentItem(2);
                break;

        }
    }
    /**
     * 设置首页分类三个颜色
     */
    private void setMainColor(int id){
        tv_main.setBackgroundResource(R.id.tv_main==id?R.drawable.icon_main_bg:0);
        tv_main_classification.setBackgroundResource(R.id.tv_main_classification==id?R.drawable.icon_main_bg:0);
        tv_main_recommend.setBackgroundResource(R.id.tv_main_recommend==id?R.drawable.icon_main_bg:0);
        tv_main.setTextColor(getResources().getColor(R.id.tv_main==id?R.color.colorfffffe:R.color.color767f8e));
        tv_main_classification.setTextColor(getResources().getColor(R.id.tv_main_classification==id?R.color.colorfffffe:R.color.color767f8e));
        tv_main_recommend.setTextColor(getResources().getColor(R.id.tv_main_recommend==id?R.color.colorfffffe:R.color.color767f8e));
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
