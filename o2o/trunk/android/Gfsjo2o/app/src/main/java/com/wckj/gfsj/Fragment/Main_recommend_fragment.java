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
 * 推荐
 */
public class Main_recommend_fragment extends Fragment implements View.OnClickListener {
    private TextView tv_new,tv_group,tv_promotion;
    private View view;
    private StopViewPage svp_context;
    private List<Fragment> pageList = new ArrayList<Fragment>();
    private FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommend, null);
        initView();
        initData();
        return view;

    }



    private void initView() {
        svp_context =  (StopViewPage) view.findViewById(R.id.svp_context);
        tv_new = (TextView) view.findViewById(R.id.tv_new);
        tv_group = (TextView) view.findViewById(R.id.tv_group);
        tv_promotion = (TextView)view. findViewById(R.id.tv_promotion);
        tv_new.setOnClickListener(this);
        tv_group.setOnClickListener(this);
        tv_promotion.setOnClickListener(this);
    }

    private void initData() {
        Bundle bundle = new Bundle();
        if (adapter == null && pageList.isEmpty()) {
            for (int i = 0; i <3 ; i++) {
                // 添加子页
                Main_recommend_new_fragment fragment = new Main_recommend_new_fragment();
                bundle.putInt("RecommendId",i);
                fragment.setArguments(bundle);
                pageList.add(fragment);
            }
            adapter = new FragmentAdapter(getChildFragmentManager());
        }

        svp_context.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_new://主页
                svp_context.setCurrentItem(0);
                break;
            case R.id.tv_group://分类
                svp_context.setCurrentItem(1);
                break;
            case R.id.tv_promotion://推荐
                svp_context.setCurrentItem(2);
                break;

        }
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
