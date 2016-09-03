package com.wckj.gfsj.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.Fragment.BankCardFragment;
import com.wckj.gfsj.Fragment.MyBrokerageFragment;
import com.wckj.gfsj.R;

/**
 * Created by rayco on 2016/7/25.
 */
public class MyBrokerageActivity extends BaseNewActivity implements View.OnClickListener {

    private TitleRelativeLayout mRlTitle;
    private View view;
    private TextView mTvMyBrokerage, mTvBankCard;

    private FragmentManager fragmentManager;
    private Fragment mMyOrderFragment, mBankCardFragment;

    @Override
    protected void init() {

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView =  inflater.inflate(R.layout.layout_public_title_main, null);
        mRlTitle = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        mRlTitle.childView.findViewById(R.id.tv_go_back).setOnClickListener(this);

        TextView tv_content_desc = (TextView) mRlTitle.childView.findViewById(R.id.tv_content_desc);
        tv_content_desc.setVisibility(View.GONE);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_my_brokerage, null);
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();
        return view;
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.tv_my_brokerage:
//                setMainColor(R.id.tv_my_brokerage);
                setTabSelection(0);
                break;
            case R.id.tv_bank_card:
//                setMainColor(R.id.tv_bank_card);
                setTabSelection(1);
                break;
        }
    }

    private void initView() {
        mTvMyBrokerage = (TextView) view.findViewById(R.id.tv_my_brokerage);
        mTvMyBrokerage.setOnClickListener(this);
        mTvBankCard = (TextView) view.findViewById(R.id.tv_bank_card);
        mTvBankCard.setOnClickListener(this);

        FrameLayout fl_context = (FrameLayout) findViewById(R.id.fl_context);
    }

    private void initData() {
//        setMainColor(R.id.tv_my_brokerage);
        setTabSelection(0);
//        setMainColor(R.id.tv_bank_card);
//        setTabSelection(1);
    }

    private void setTabSelection(int index) {
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:// 我的佣金
                if (mMyOrderFragment == null) {
                    mMyOrderFragment = new MyBrokerageFragment();
                    transaction.add(R.id.fl_context, mMyOrderFragment);
                } else {
                    transaction.show(mMyOrderFragment);
                }
                transaction.commit();
                break;
            case 1:// 银行卡管理
                if (mBankCardFragment == null) {
                    mBankCardFragment = new BankCardFragment();
                    transaction.add(R.id.fl_context, mBankCardFragment);
                } else {
                    transaction.show(mBankCardFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }

    // 隐藏所有Fragment
    private void hideFragments(FragmentTransaction transaction) {
        if (mMyOrderFragment != null) {
            transaction.hide(mMyOrderFragment);
        }
        if (mBankCardFragment != null) {
            transaction.hide(mBankCardFragment);
        }
    }

//    private void setMainColor(int id){
//        mTvMyBrokerage.setBackgroundColor(getResources().getColor(R.id.tv_my_brokerage==id?R.color.white:R.color.color_97888a));
//        mTvBankCard.setBackgroundColor(getResources().getColor(R.id.tv_bank_card==id?R.color.white:R.color.color_97888a));
//        mTvMyBrokerage.setTextColor(getResources().getColor(R.id.tv_my_brokerage==id?R.color.color_444444:R.color.color_e3e6eb));
//        mTvBankCard.setTextColor(getResources().getColor(R.id.tv_bank_card==id?R.color.color_444444:R.color.color_e3e6eb));
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRlTitle.clearRegister();
    }
}
