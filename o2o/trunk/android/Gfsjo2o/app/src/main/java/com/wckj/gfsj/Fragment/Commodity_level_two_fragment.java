package com.wckj.gfsj.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;

import com.wckj.gfsj.Activity.CommodityLevelThreeActivity;
import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.entity.CategoryThree;
import com.wckj.gfsj.CustomUi.ScaleItemGridView;
import com.wckj.gfsj.R;

import java.util.ArrayList;

/**
 * 二级商品gridview列表
 */
public class Commodity_level_two_fragment extends Fragment {

    private ScaleItemGridView gv_two_commodity;
    private View view;
    private CommonAdapter mAapter;
    private String ceshi;
    private ArrayList<CategoryThree> mCategotyList;

    private AnimationSet mAnimationSet;
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1, 1.3f, 1, 1.3f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gv_commodity_two, null);
        Bundle bundle = getArguments();
        ceshi = bundle.getString("title");
        mCategotyList = (ArrayList) bundle.getSerializable("categoryThree");
        if (mCategotyList == null) {
            mCategotyList = new ArrayList<>();
        }

        gv_two_commodity = (ScaleItemGridView) view.findViewById(R.id.gv_two_commodity);
        bindData();
        setListener();
        return view;
    }

    //gridview点击
    private void setListener() {
        gv_two_commodity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                startAnimation(v);
                if (mAapter != null) {
                    mAapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        gv_two_commodity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                startAnimation(v);
                if (mAapter != null) {
                    mAapter.notifyDataSetChanged();
                }

                if (position >= mCategotyList.size()) {
                    return;
                }
                CategoryThree item = (CategoryThree) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), CommodityLevelThreeActivity.class);
                intent.putExtra("categoryId", Integer.parseInt(item.getId()));
                startActivity(intent);
            }
        });
    }

    /**
     * 播放动画
     *
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

    private void bindData() {
        if (mAapter == null) {
            mAapter = new CommonAdapter<CategoryThree>(view.getContext(), mCategotyList, R.layout.item_gv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, CategoryThree item, int position) {
                    helper.setText(R.id.tv_name, item.getTitle());
                    helper.setImageByUrl(R.id.iv_commodity_two, item.getImageUrl(), R.drawable.icon_public_classification);
                }
            };
            gv_two_commodity.setAdapter(mAapter);
        } else {
            mAapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAapter = null;
    }
}
