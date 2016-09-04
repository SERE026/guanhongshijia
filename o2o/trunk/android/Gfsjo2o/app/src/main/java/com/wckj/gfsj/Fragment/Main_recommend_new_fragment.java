package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Activity.CommoditydetailsActivity;
import com.wckj.gfsj.Adapter.RecommendAdapter;
import com.wckj.gfsj.Bean.RecommendGoodsGroupResult;
import com.wckj.gfsj.Bean.RecommendGoodsPromotionResult;
import com.wckj.gfsj.Bean.RecommendGoodsRequest;
import com.wckj.gfsj.Bean.RecommendNewGoodsResult;
import com.wckj.gfsj.Bean.entity.Recommend;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.LoadGridView;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.ImageLoaderUtil;

import java.util.List;

import okhttp3.Call;

/**
 * 推荐更多商品
 */
public class Main_recommend_new_fragment extends BaseNewFragment {
    private View view;
    private LoadGridView gv_recommend;
    private RecommendAdapter mRecommendAdapter;
    private int typeId;
    private String url, mImage;
    private RecommendNewGoodsResult result;
    private RecommendGoodsPromotionResult promotionResult;
    private RecommendGoodsGroupResult groupResult;
    private List<Recommend> mList;

    private AnimationSet mAnimationSet;
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1, 1.3f, 1, 1.3f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    @Override
    protected void init() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            typeId = arguments.getInt("recommendId");
        }
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.fragment_main_recommend, null);
        initView();
        setListener();
        return view;
    }

    @Override
    protected void load() {
        getGoodsRecommend();
    }

    @Override
    protected void refreshOrLoadView() {

    }

    /**
     * 播放动画
     * @param v
     */
    private void startAnimation(View v) {
        AnimationSet animationSet = new AnimationSet(true);
        if (mAnimationSet != null && mAnimationSet != animationSet) {
            scaleAnimation.setDuration(100);
            mAnimationSet.addAnimation(scaleAnimation);
            mAnimationSet.setFillAfter(false);
            v.startAnimation(mAnimationSet);
        }
        scaleAnimation1.setDuration(100);
        animationSet.addAnimation(scaleAnimation1);
        animationSet.setFillAfter(true);
        v.startAnimation(animationSet);
        mAnimationSet = animationSet;
    }

    private void setListener() {
        gv_recommend.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                startAnimation(v);
                if (mRecommendAdapter != null) {
                    mRecommendAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                startAnimation(v);
                if (mRecommendAdapter != null) {
                    mRecommendAdapter.notifyDataSetChanged();
                }

                if (position >= mList.size()) {
                    return;
                }
                Intent intent = new Intent(view.getContext(), CommoditydetailsActivity.class);
                Recommend recommend = (Recommend) parent.getItemAtPosition(position);
                intent.putExtra("goodsId", recommend.getId());
                startActivity(intent);
            }
        });
    }

    private void initView() {
        gv_recommend = (LoadGridView) view.findViewById(R.id.gv_recommend);
        ImageView iv_recommend_flag_pic = (ImageView) view.findViewById(R.id.iv_recommend_flag_pic);
        ImageLoaderUtil.getInstance().displayImageView(mImage, iv_recommend_flag_pic);

        mRecommendAdapter = new RecommendAdapter(view.getContext(), mList);
        gv_recommend.setAdapter(mRecommendAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRecommendAdapter = null;
    }

    //推荐
    private void getGoodsRecommend() {
        final RecommendGoodsRequest request = new RecommendGoodsRequest();
        switch (typeId) {
            case 0:
                url = GlobalUtils.NEW_RECOMMEND_URL;
                break;
            case 1:
                url = GlobalUtils.GROUP_RECOMMEND_URL;
                break;
            case 2:
                url = GlobalUtils.PROMOTION_RECOMMEND_URL;
                break;
        }
        HttpUtils.getInstance().asyncPost(request, url, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                switch (typeId) {
                    case 0:
                        result = JSON.parseObject(response, RecommendNewGoodsResult.class);
                        mList = result.getNewList();
                        mImage = result.getImage();
                        break;
                    case 1:
                        groupResult = JSON.parseObject(response, RecommendGoodsGroupResult.class);
                        mList = groupResult.getGroupList();
                        mImage = groupResult.getImage();
                        break;
                    case 2:
                        promotionResult = JSON.parseObject(response, RecommendGoodsPromotionResult.class);
                        mList = promotionResult.getPromotionList();
                        mImage = promotionResult.getImage();
                        break;
                }
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });
    }
}
