package com.wckj.gfsj.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.R;

import java.util.List;

public abstract  class BaseNewActivity extends FragmentActivity {
    protected FrameLoadLayout loadPage;
    protected Handler handler;
    protected LayoutInflater inflater;//父类的插入器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_new);
        loadPage = new FrameLoadLayout(this) {
            @Override
            public View createSuccessView() {
                return BaseNewActivity.this.onCreateSuccessView();
            }

            @Override
            public void setRefreshORLoad() {
                refreshOrLoadView();
            }

            @Override
            public void loadMainRun() {
                BaseNewActivity.this.load();
            }
        };
        if (handler == null) {
            handler = new Handler() {
                public void handleMessage(Message msg) {
                    BaseNewActivity.this.handleMessage(msg);
                }
            };
        }
        init();
        FrameLayout fl_base_title = (FrameLayout) findViewById(R.id.fl_base_title);
        FrameLayout fl_base_content = (FrameLayout) findViewById(R.id.fl_base_content);
        inflater = LayoutInflater.from(this);
        View mTitleView = onCreateTitleView(inflater);
        if(mTitleView!=null)
            fl_base_title.addView(mTitleView);
       else
            fl_base_title.setVisibility(View.GONE);

        fl_base_content.addView(loadPage, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        loadPage.showState(); // 设置网络返回的状态一定要调用它不调用它不会调用访问网络的方法
    }



    /**
     * 设置有没有用长连接，调用方法loadPage.setSocket（）
     * true：长连接短连接都调用
     * false：只用了短连接
     * 默认false，不需要实现该方法
     * 同时做一些最开始的初始化
     */
    protected abstract void init();
    /**
     * 创建标题的View，需要什么标题在父类里面onCreateNativeTitleView（）方法里面加，能后返回加的type就行
     * @return 默认返回没有标题
     */
    protected abstract View onCreateTitleView(LayoutInflater inflater);
    /**
     * 访问数据后，拿到成功得界面
     *
     * @return
     */
    protected abstract View onCreateSuccessView();
    /**
     * 页面已经成功了之后
     * 需要在刷新页面调用这个方法
     */
    protected abstract  void refreshOrLoadView();
    /**
     * handler得处理
     */
    protected void handleMessage(Message msg) {
    }
    /**
     * 发送长连接请求
     * 请求成功后需要调用loadPage.showPage(LoadResult)
     */
    protected void load() {

    }


    /** 校验数据 */
    protected FrameLoadLayout.LoadResult checkData(List datas) {
        if (datas == null) {
            return FrameLoadLayout.LoadResult.error;// 请求服务器失败
        } else {
            if (datas.size() == 0) {
                return FrameLoadLayout.LoadResult.empty;
            } else {
                return FrameLoadLayout.LoadResult.success;
            }
        }
    }

    /**
     * result可以根据checkData（），获取
     * 根据result 结果显示页面。
     * @param result
     */
    protected void showPageState(FrameLoadLayout.LoadResult result){
        if (result != null) {// 不为空得话展示一遍成功得界面
            loadPage.setState(result.getValue());
            loadPage.showPage();
        }
    }
    /**
     * 再次调用相对应的load方法加载数据，游客LoadRun，登陆LoadMainRun
     * 能后根据load对应结果自动展示数据
     */
    protected void showState(){
        if(loadPage!=null){
            loadPage.showState();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
    }

}
