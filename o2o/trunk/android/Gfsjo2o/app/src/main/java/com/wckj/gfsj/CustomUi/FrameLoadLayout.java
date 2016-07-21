package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 初始化三个状态
 *
 * @author win acr
 */
public abstract class FrameLoadLayout extends FrameLayout {
    public static final int STATE_UNKOWN = 0;// 当前得状态不知道得情况,一般是刚进入界面时候得状态
    public static final int STATE_LOAD = 1;// 加载中得状态
    public static final int STATE_EMPTY = 2;// 数据空得状态
    public static final int STATE_ERROR = 3;// 数据错误得状态,或者没有网络的界面
    public static final int STATE_SUCCESS = 4;// 状态成功得状态
    private int state = STATE_UNKOWN;

    private View mLoadView;
    public View mEmptyView;
    private View mErrorView;
    private View mSuccessView;




    public FrameLoadLayout(Context context) {
        super(context);
        init();
    }

    public FrameLoadLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FrameLoadLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化 把加载中的页面加到页面上 把空的错误的页面都加载到页面上
     */
    private void init() {
        mLoadView = createLoadingView();
        if (mLoadView != null) {
            this.addView(mLoadView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        mEmptyView = createEmptyView();
        if (mEmptyView != null) {
            this.addView(mEmptyView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        mErrorView = createErrorView();
        if (mErrorView != null) {
            this.addView(mErrorView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
    }

    /**
     * 页面切换改变
     * <p>
     * 根据服务端返回的状态切换页面
     */
    public void showPage() {
        if (mLoadView != null) {
            mLoadView.setVisibility(state == STATE_UNKOWN
                    || state == STATE_LOAD ? View.VISIBLE : View.INVISIBLE);

        }

        if (mEmptyView != null) {
            mEmptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE
                    : View.INVISIBLE);

        }

        if (mErrorView != null) {
            mErrorView.setVisibility(state == STATE_ERROR ? View.VISIBLE
                    : View.INVISIBLE);
        }
        if (state == STATE_SUCCESS) {// 成功界面
            if (mSuccessView == null) {
                mSuccessView = createSuccessView();
                addView(mSuccessView, new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            } else {
                setRefreshORLoad();
            }
            mSuccessView.setVisibility(View.VISIBLE);
        } else {// 不成功界面
            if (mSuccessView != null) {
                mSuccessView.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * 根据服务端的状态改变相应的状态，
     * 注意访问网络获取状态是在线程中执行所以需要切换到主线程中执行切换的过程,需要自定义一个在主线程中运行的handle或者判断是否在主线程中执行
     */
    public void showState() {
        if (state == STATE_EMPTY || state == STATE_ERROR) {
            state = STATE_LOAD;
        }

        if (state == STATE_LOAD || state == STATE_UNKOWN) {
            showPage();// 如果你需要每次刷新的时候重置正在刷新的这个状态一直转圈圈得状态，需要调用这个方法，如果不需要的话这个方法就不需要调用，只要在头的时候调用一下
        }

        loadMainRun();
    }




    /**
     * 根据当前的state选择什么状态
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    /**
     * 当View创建得时候需要它重新绑定数据，或者额外操作得时候调用这个方法
     */
    public void setRefreshORLoad() {
    }

    /**
     * 非线程,用到长连接返回false
     *
     */
    public void loadMainRun() {
    }

    /**
     * 创建成功得界面，主线程中执行得
     *
     * @return 成功得界面
     */
    public abstract View createSuccessView();

    /**
     * 正在加载中得界面
     */
    private View createLoadingView() {
//        View startLoadView = LayoutInflater.from(getContext()).inflate(
//                R.layout.public_startloading, null);
//        rotateLoadingView = (RotateLoadingView) startLoadView
//                .findViewById(R.id.rotateLoadingView);
        return null;
    }

    /**
     * 错误得界面没有网络得
     */
    private View createErrorView() {
//        View notNetWork = LayoutInflater.from(getContext()).inflate(
//                R.layout.mr_networkerror, null);
//        RelativeLayout btn = (RelativeLayout) notNetWork
//                .findViewById(R.id.btn_network);
//
//        btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//
//                showState();
//            }
//        });
        return null;
    }

    public ImageView tv_networktext;
    public TextView tv_msgtext1;
    public TextView tv_msgtext2;

    /**
     * 正在没有数据得界面
     */

    private View createEmptyView() {
//        View noDataView = LayoutInflater.from(getContext()).inflate(
//                R.layout.mr_public_nodata, null);
//        tv_networktext = (ImageView) noDataView
//                .findViewById(R.id.tv_networktext);
//        tv_msgtext1 = (TextView) noDataView.findViewById(R.id.tv_msgtext1);
//        tv_msgtext2 = (TextView) noDataView.findViewById(R.id.tv_msgtext2);
//        tv_msgtext1.setVisibility(View.GONE);
//        RelativeLayout rl_nodata = (RelativeLayout) noDataView
//                .findViewById(R.id.rl_nodata);
//        rl_nodata.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                showState();
//            }
//        });
        return null;
    }

    public enum LoadResult {
        // 定义属性
        empty(2), error(3), success(4);
        int value;

        public int getValue() {
            return value;
        }

        private LoadResult(int value) {
            this.value = value;
        }
    }


}
