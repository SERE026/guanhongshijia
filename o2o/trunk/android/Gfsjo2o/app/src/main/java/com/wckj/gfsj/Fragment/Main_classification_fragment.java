package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.bridge.OpenEffectBridge;
import com.open.androidtvwidget.view.MainUpView;
import com.open.androidtvwidget.view.RelativeMainLayout;
import com.wckj.gfsj.Activity.CommodityLevelTwoActivity;
import com.wckj.gfsj.Activity.MainMoreActivity;
import com.wckj.gfsj.R;

/**
 * Created by 小爱爱 on 2016/7/15.
 * 分类
 */
public class Main_classification_fragment extends Fragment implements View.OnClickListener {
    private View view;
    private MainUpView mMainUpView;
    private View mOldFocus;

    private OpenEffectBridge mOpenEffectBridge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_main_classification, null);

        mMainUpView = (MainUpView) view.findViewById(R.id.main_up_view);
        mMainUpView.setEffectBridge(new EffectNoDrawBridge());
        mOpenEffectBridge = (EffectNoDrawBridge) mMainUpView.getEffectBridge();
        mOpenEffectBridge.setTranDurAnimTime(200);
        mMainUpView.setUpRectResource(R.drawable.white_light);// 设置移动边框的图片.
//        mMainUpView.setShadowResource(R.drawable.item_shadow); // 设置移动边框的阴影.
        mMainUpView.setDrawUpRectPadding(new Rect(13, 13, 12, 12));

        RelativeMainLayout rlFrame = (RelativeMainLayout) view.findViewById(R.id.rl_frame);
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

        view.findViewById(R.id.btn_more).setOnClickListener(this);
        view.findViewById(R.id.btn_old_tea).setOnClickListener(this);
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
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_more:
                 intent = new Intent(view.getContext(), MainMoreActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_old_tea:
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
