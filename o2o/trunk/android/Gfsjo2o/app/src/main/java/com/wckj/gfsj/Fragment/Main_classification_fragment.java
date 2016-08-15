package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.bridge.OpenEffectBridge;
import com.open.androidtvwidget.view.MainUpView;
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
    private MainUpView mMainUpView;
    private View mOldFocus;

    private TextView mTvChineseFurniture, mTvClassicalFurniture, mTvFourTreasures, mTvStrokes,
            mTvOldTea, mTvRedWine, mTvSoftDaquan, mTvDecorativeDaquan, mTvClassicalDecorativeMaterials,
            mTvClassicalLighting, mTvNews, mTvMore;

    private OpenEffectBridge mOpenEffectBridge;

    List<Category> mCategoryList = new ArrayList<Category>();

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        return null;
    }

    @Override
    protected View onCreateSuccessView() {
        view =  inflater.inflate(R.layout.fragment_main_classification, null);

        mMainUpView = (MainUpView) view.findViewById(R.id.main_up_view);
        mMainUpView.setEffectBridge(new EffectNoDrawBridge());
        mOpenEffectBridge = (EffectNoDrawBridge) mMainUpView.getEffectBridge();
        mOpenEffectBridge.setTranDurAnimTime(200);
//        mMainUpView.setUpRectResource(R.drawable.white_light);// 设置移动边框的图片.
//        mMainUpView.setShadowResource(R.drawable.item_shadow); // 设置移动边框的阴影.
        mMainUpView.setDrawUpRectPadding(new Rect(13, 13, 12, 12));

        RelativeLayout rlFrame = (RelativeLayout) view.findViewById(R.id.rl_frame);
        rlFrame.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(final View oldFocus, final View newFocus) {
                if (newFocus != null)
                    newFocus.bringToFront();
                float scale = 1.2f;
                mMainUpView.setFocusView(newFocus, mOldFocus, scale);
                mOldFocus = newFocus;
            }
        });

        for (int i = 0; i < rlFrame.getChildCount(); i++) {
            rlFrame.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        v.requestFocus();
                    }
                    return false;
                }
            });
        }

        view.findViewById(R.id.rf_more).setOnClickListener(this);
        view.findViewById(R.id.rf_old_tea).setOnClickListener(this);
        view.findViewById(R.id.rf_chinese_furniture).setOnClickListener(this);

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

        return view;
    }

    @Override
    protected void load() {
        getCategoryMain();
        showPageState(FrameLoadLayout.LoadResult.success);
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
                    if (mCategoryList != null && !mCategoryList.isEmpty()) {
                        mTvChineseFurniture.setText(mCategoryList.get(0).getTitle());
                        mTvClassicalFurniture.setText(mCategoryList.get(1).getTitle());
                        mTvFourTreasures.setText(mCategoryList.get(2).getTitle());
                        mTvStrokes.setText(mCategoryList.get(3).getTitle());
                        mTvOldTea.setText(mCategoryList.get(4).getTitle());
                        mTvRedWine.setText(mCategoryList.get(5).getTitle());
                        mTvSoftDaquan.setText(mCategoryList.get(6).getTitle());
                        mTvDecorativeDaquan.setText(mCategoryList.get(7).getTitle());
                        mTvClassicalDecorativeMaterials.setText(mCategoryList.get(8).getTitle());
                        mTvClassicalLighting.setText(mCategoryList.get(9).getTitle());
                        mTvNews.setText(mCategoryList.get(10).getTitle());
                    }
                }
                LogUtil.i(response);
            }
        } );
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.rf_more:
                 intent = new Intent(view.getContext(), MainMoreActivity.class);
                startActivity(intent);
                break;
            case R.id.rf_old_tea:
                intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.rf_chinese_furniture:
                intent = new Intent(view.getContext(), CommodityLevelTwoActivity.class);
                intent.putExtra("id",mCategoryList.get(0).getId());
                startActivity(intent);
                break;
        }
    }
}
