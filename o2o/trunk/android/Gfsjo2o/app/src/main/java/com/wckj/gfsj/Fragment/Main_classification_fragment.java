package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.open.androidtvwidget.view.ReflectItemView;
import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Activity.MainMoreActivity;
import com.wckj.gfsj.Bean.MainCategoryRequest;
import com.wckj.gfsj.Bean.MainCategoryResult;
import com.wckj.gfsj.Bean.entity.Category;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.ImageLoaderUtil;
import com.wckj.gfsj.Utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends BaseNewFragment implements View.OnClickListener {
    private View view;

    private ReflectItemView mRfChineseFurniture, mRfClassicalFurniture, mRfFourTreasures, mRfStrokes,
            mRfOldTea, mRfRedWine, mRfSoftDaquan, mRfDecorativeDaquan, mRfClassicalDecorativeMaterials,
            mRfClassicalLighting, mRfNews, mRfMore;

    private TextView mTvChineseFurniture, mTvClassicalFurniture, mTvFourTreasures, mTvStrokes,
            mTvOldTea, mTvRedWine, mTvSoftDaquan, mTvDecorativeDaquan, mTvClassicalDecorativeMaterials,
            mTvClassicalLighting, mTvNews, mTvMore;
    private ImageView mIvChineseFurniture, mIvClassicalFurniture, mIvFourTreasures, mIvStrokes,
            mIvOldTea, mIvRedWine;

    private List<Category> mCategoryList = new ArrayList<Category>();

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.fragment_main_classification, null);
        RelativeLayout rlFrame = (RelativeLayout) view.findViewById(R.id.rl_frame);
        for (int i = 0; i < rlFrame.getChildCount(); i++) {
            rlFrame.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (v != null) {
                        if (hasFocus) {
                            v.setScaleX(1.2f);
                            v.setScaleY(1.2f);
                            v.bringToFront();
                        } else {
                            v.setScaleX(1.0f);
                            v.setScaleY(1.0f);
                        }
                    }
                }
            });
        }

        mRfChineseFurniture = (ReflectItemView) view.findViewById(R.id.rf_chinese_furniture);
        mRfClassicalFurniture = (ReflectItemView) view.findViewById(R.id.rf_classical_furniture);
        mRfFourTreasures = (ReflectItemView) view.findViewById(R.id.rf_four_treasures);
        mRfStrokes = (ReflectItemView) view.findViewById(R.id.rf_strokes);
        mRfOldTea = (ReflectItemView) view.findViewById(R.id.rf_old_tea);
        mRfRedWine = (ReflectItemView) view.findViewById(R.id.rf_red_wine);
        mRfSoftDaquan = (ReflectItemView) view.findViewById(R.id.rf_soft_daquan);
        mRfDecorativeDaquan = (ReflectItemView) view.findViewById(R.id.rf_decorative_daquan);
        mRfClassicalDecorativeMaterials = (ReflectItemView) view.findViewById(R.id.rf_classical_decorative_materials);
        mRfClassicalLighting = (ReflectItemView) view.findViewById(R.id.rf_classical_lighting);
        mRfNews = (ReflectItemView) view.findViewById(R.id.rf_news);
        mRfMore = (ReflectItemView) view.findViewById(R.id.rf_more);

        mRfChineseFurniture.setOnClickListener(this);
        mRfClassicalFurniture.setOnClickListener(this);
        mRfFourTreasures.setOnClickListener(this);
        mRfStrokes.setOnClickListener(this);
        mRfOldTea.setOnClickListener(this);
        mRfRedWine.setOnClickListener(this);
        mRfSoftDaquan.setOnClickListener(this);
        mRfDecorativeDaquan.setOnClickListener(this);
        mRfClassicalDecorativeMaterials.setOnClickListener(this);
        mRfClassicalLighting.setOnClickListener(this);
        mRfNews.setOnClickListener(this);
        mRfMore.setOnClickListener(this);

        mTvChineseFurniture = (TextView) view.findViewById(R.id.tv_chinese_furniture);
        mTvClassicalFurniture = (TextView) view.findViewById(R.id.tv_classical_furniture);
        mTvFourTreasures = (TextView) view.findViewById(R.id.tv_four_treasures);
        mTvStrokes = (TextView) view.findViewById(R.id.tv_strokes);
        mTvOldTea = (TextView) view.findViewById(R.id.tv_old_tea);
        mTvRedWine = (TextView) view.findViewById(R.id.tv_red_wine);
        mTvSoftDaquan = (TextView) view.findViewById(R.id.tv_soft_daquan);
        mTvDecorativeDaquan = (TextView) view.findViewById(R.id.tv_decorative_daquan);
        mTvClassicalDecorativeMaterials = (TextView) view.findViewById(R.id.tv_classical_decorative_materials);
        mTvClassicalLighting = (TextView) view.findViewById(R.id.tv_classical_lighting);
        mTvNews = (TextView) view.findViewById(R.id.tv_news);

        mIvChineseFurniture = (ImageView) view.findViewById(R.id.iv_chinese_furniture);
        mIvClassicalFurniture = (ImageView) view.findViewById(R.id.iv_classical_furniture);
        mIvFourTreasures = (ImageView) view.findViewById(R.id.iv_four_treasures);
        mIvStrokes = (ImageView) view.findViewById(R.id.iv_strokes);
        mIvOldTea = (ImageView) view.findViewById(R.id.iv_old_tea);
        mIvRedWine = (ImageView) view.findViewById(R.id.iv_red_wine);

        if (mCategoryList != null && mCategoryList.size() >= 11) {
            mTvChineseFurniture.setText(mCategoryList.get(0).getTitle());
            if (mCategoryList.get(0).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(0).getImageUrl(), mIvChineseFurniture);
            }
            mTvClassicalFurniture.setText(mCategoryList.get(1).getTitle());
            if (mCategoryList.get(1).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(1).getImageUrl(), mIvClassicalFurniture);
            }
            mTvFourTreasures.setText(mCategoryList.get(2).getTitle());
            if (mCategoryList.get(2).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(2).getImageUrl(), mIvFourTreasures);
            }
            mTvStrokes.setText(mCategoryList.get(3).getTitle());
            if (mCategoryList.get(3).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(3).getImageUrl(), mIvStrokes);
            }
            mTvOldTea.setText(mCategoryList.get(4).getTitle());
            if (mCategoryList.get(4).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(4).getImageUrl(), mIvOldTea);
            }
            mTvRedWine.setText(mCategoryList.get(5).getTitle());
            if (mCategoryList.get(5).getImageUrl() != null) {
                ImageLoaderUtil.getInstance().displayImageView(mCategoryList.get(5).getImageUrl(), mIvRedWine);
            }
            mTvSoftDaquan.setText(mCategoryList.get(6).getTitle());
            mTvDecorativeDaquan.setText(mCategoryList.get(7).getTitle());
            mTvClassicalDecorativeMaterials.setText(mCategoryList.get(8).getTitle());
            mTvClassicalLighting.setText(mCategoryList.get(9).getTitle());
            mTvNews.setText(mCategoryList.get(10).getTitle());
        }
        return view;
    }

    @Override
    protected void load() {
        getCategoryMain();
    }

    /**
     * 获取主分类列表命令
     */
    private void getCategoryMain() {
        MainCategoryRequest request = new MainCategoryRequest();
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CATEGORY_MAIN_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                LogUtil.e("{" + e.toString() + "}");
            }

            @Override
            public void onSuccess(String response) {
                MainCategoryResult json = JSON.parseObject(response, MainCategoryResult.class);
                int resultCode = json.getResultCode();
                if (resultCode == 0) {
                    mCategoryList = json.getCategoryList();
                }
                showPageState(FrameLoadLayout.LoadResult.success);
                LogUtil.i(response);
            }
        });
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.rf_chinese_furniture:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(0).getId());
                    intent.putExtra("category", mCategoryList.get(0).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_classical_furniture:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(1).getId());
                    intent.putExtra("category", mCategoryList.get(1).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_four_treasures:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(2).getId());
                    intent.putExtra("category", mCategoryList.get(2).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_strokes:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(3).getId());
                    intent.putExtra("category", mCategoryList.get(3).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_old_tea:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(4).getId());
                    intent.putExtra("category", mCategoryList.get(4).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_red_wine:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(5).getId());
                    intent.putExtra("category", mCategoryList.get(5).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_soft_daquan:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(6).getId());
                    intent.putExtra("category", mCategoryList.get(6).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_decorative_daquan:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(7).getId());
                    intent.putExtra("category", mCategoryList.get(7).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_classical_decorative_materials:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(8).getId());
                    intent.putExtra("category", mCategoryList.get(8).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_classical_lighting:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(9).getId());
                    intent.putExtra("category", mCategoryList.get(9).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_news:
                if (mCategoryList != null && mCategoryList.size() >= 11) {
                    intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                    intent.putExtra("id", mCategoryList.get(10).getId());
                    intent.putExtra("category", mCategoryList.get(10).getTitle());
                    startActivity(intent);
                }
                break;
            case R.id.rf_more:
                intent = new Intent(view.getContext(), MainMoreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
