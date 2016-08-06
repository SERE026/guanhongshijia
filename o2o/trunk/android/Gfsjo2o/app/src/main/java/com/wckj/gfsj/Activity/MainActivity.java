package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.Fragment.Collect_fragment;
import com.wckj.gfsj.Fragment.Main_fragment;
import com.wckj.gfsj.Fragment.Search_fragment;
import com.wckj.gfsj.Fragment.Shopping_cart_fragment;
import com.wckj.gfsj.Fragment.User_fragment;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.OwerToastShow;
import com.wckj.gfsj.Utils.TimeUtils;

import de.greenrobot.event.EventBus;

/**
 * 主页
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private Fragment main_fragment, searchFragment, user_fragment, shopping_cart_fragment, collect_fragment;
    private FragmentManager fragmentManager;
    private TextView tv_time;
    private int position;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            EventBus.getDefault().post(new TimeEvent(TimeUtils.showTime(TimeUtils.getSystemTime())));
            tv_time.setText(TimeUtils.showTime(TimeUtils.getSystemTime()));
            handler.sendEmptyMessageDelayed(0, 3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.rl_search).setOnClickListener(this);
        findViewById(R.id.tv_collect).setOnClickListener(this);
        findViewById(R.id.tv_shopping_cart).setOnClickListener(this);
        findViewById(R.id.tv_mine_center).setOnClickListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);

        handler.sendEmptyMessage(0);
        FrameLayout fl_context = (FrameLayout) findViewById(R.id.fl_context);
    }

    private void initData() {
        setTabSelection(1);
    }

    public void setTabSelection(int index) {
        this.position = index;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:// 默认主页
                if (main_fragment == null) {
                    main_fragment = new Main_fragment();
                    transaction.add(R.id.fl_context, main_fragment);
                } else {
                    transaction.show(main_fragment);

                }
                transaction.commit();
                break;
            case 1://用户
                if (user_fragment == null) {
                    user_fragment = new User_fragment();
                    transaction.add(R.id.fl_context, user_fragment);
                } else {
                    transaction.show(user_fragment);
                }
                transaction.commit();
                break;
            case 2:// 购物车
                if (shopping_cart_fragment == null) {
                    shopping_cart_fragment = new Shopping_cart_fragment();
                    transaction.add(R.id.fl_context, shopping_cart_fragment);
                } else {
                    transaction.show(shopping_cart_fragment);
                }
                transaction.commit();
                break;
            case 3:// 收藏
                if (collect_fragment == null) {
                    collect_fragment = new Collect_fragment();
                    transaction.add(R.id.fl_context, collect_fragment);
                } else {
                    transaction.show(collect_fragment);
                }
                transaction.commit();
                break;
            case 4:// 搜索
                if (searchFragment == null) {
                    searchFragment = new Search_fragment();
                    transaction.add(R.id.fl_context, searchFragment);
                } else {
                    transaction.show(searchFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }

    // 隐藏所以Fragment
    private void hideFragments(FragmentTransaction transaction) {
        if (main_fragment != null) {
            transaction.hide(main_fragment);
        }
        if (shopping_cart_fragment != null) {
            transaction.hide(shopping_cart_fragment);
        }
        if (collect_fragment != null) {
            transaction.hide(collect_fragment);
        }
        if (user_fragment != null) {
            transaction.hide(user_fragment);
        }
        if (searchFragment != null) {
            transaction.hide(searchFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_search:
                setTabSelection(4);
                break;
            case R.id.tv_collect:
                setTabSelection(3);
                break;
            case R.id.tv_shopping_cart:
                setTabSelection(2);
                break;
            case R.id.tv_mine_center:
                setTabSelection(1);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        getExtraAndSetIndex();
    }
    public void getExtraAndSetIndex() {
        Intent intent=getIntent();
        if(intent!=null){
            int index = intent.getIntExtra("position", 0);

            setTabSelection(index);
        }
    }


    private long mkeyTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (position != 0) {
                setTabSelection(0);
                return  false ;
            } else {
                if (mkeyTime == 0 || (System.currentTimeMillis() - mkeyTime) > 2000) {
                   OwerToastShow.show(this, "再按一次退出程序");
                   mkeyTime = System.currentTimeMillis();
                    return  false ;
                }
                return super.onKeyDown(keyCode, event);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}