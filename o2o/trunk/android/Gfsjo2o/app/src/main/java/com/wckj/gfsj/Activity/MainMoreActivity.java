package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.MoreRecommendAdapter;
import com.wckj.gfsj.Bean.MoreCategoryRequest;
import com.wckj.gfsj.Bean.MoreCategoryResult;
import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.Bean.entity.Category;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import okhttp3.Call;

/**
 * Created by jinlei on 2016/7/21.
 * 更多一级商品列表
 */
public class MainMoreActivity extends BaseNewActivity implements View.OnClickListener {

    private List<Category> mCategoryList;
    private GridView gv_more_recommend;
    private TextView tv_go_back;
    private MoreRecommendAdapter mRecommendMoreAdapter;
    private View view;
    private TextView tv_time;


    @Override
    protected void init() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_more, null);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
         tv_time =  (TextView) titleView.findViewById(R.id.tv_time);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_recommend_more_gridview, null);
        initView();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {

        getMoreCategory();

    }

    private void getMoreCategory() {
        MoreCategoryRequest request = new MoreCategoryRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CATEGORY_MORE_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                MoreCategoryResult json = JSON.parseObject(response, MoreCategoryResult.class);
                mCategoryList =  json.getCategoryList();
                showPageState(checkData(mCategoryList));
            }
        });

    }

    private void initView() {
        gv_more_recommend = (GridView) view.findViewById(R.id.gv_more_recommend);


        mRecommendMoreAdapter = new MoreRecommendAdapter(this, mCategoryList);
        gv_more_recommend.setAdapter(mRecommendMoreAdapter);
        gv_more_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                intent.putExtra("id",mCategoryList.get(position).getId());
                intent.putExtra("category",mCategoryList.get(position).getTitle());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onMainTimeEvent(TimeEvent time) {
        if (tv_time != null) {
            tv_time.setText(time.getTime());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
