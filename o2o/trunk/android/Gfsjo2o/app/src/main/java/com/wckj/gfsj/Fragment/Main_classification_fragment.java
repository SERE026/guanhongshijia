package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.bridge.OpenEffectBridge;
import com.open.androidtvwidget.view.MainUpView;
import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Activity.MainMoreActivity;
import com.wckj.gfsj.Bean.MainCategoryRequest;
import com.wckj.gfsj.Bean.MainCategoryResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import okhttp3.Call;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends BaseNewFragment implements View.OnClickListener {
    private View view;
    private MainUpView mMainUpView;
    private View mOldFocus;

    private OpenEffectBridge mOpenEffectBridge;


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

        view.findViewById(R.id.rf_more).setOnClickListener(this);
        view.findViewById(R.id.rf_old_tea).setOnClickListener(this);
        view.findViewById(R.id.rf_chinese_furniture).setOnClickListener(this);

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

        return view;
    }

    @Override
    protected void load() {
//        getCategoryMain();
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
            }
            @Override
            public void onSuccess(String responsed) {
                JSON.parseObject(responsed, MainCategoryResult.class);

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
                startActivity(intent);
                break;

        }
    }
}
