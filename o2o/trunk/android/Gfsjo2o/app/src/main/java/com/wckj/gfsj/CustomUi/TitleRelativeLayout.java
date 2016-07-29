package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wckj.gfsj.Activity.MainActivity;
import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 共有的标题点击事件
 */
public class TitleRelativeLayout extends RelativeLayout implements View.OnClickListener {

    public View childView;
    private TextView tv_time;

    public TitleRelativeLayout(Context context) {
        super(context);
        initView();
    }


    public TitleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TitleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        EventBus.getDefault().register(this);
        childView = View.inflate(getContext(), R.layout.layout_title_main_go_back, null);
        TextView tv_mine_center = (TextView) childView.findViewById(R.id.tv_mine_center);
        TextView tv_shopping_cart = (TextView) childView.findViewById(R.id.tv_shopping_cart);
        TextView tv_collect = (TextView) childView.findViewById(R.id.tv_collect);
        RelativeLayout rl_search = (RelativeLayout) childView.findViewById(R.id.rl_search);
        tv_time = (TextView) childView.findViewById(R.id.tv_time);

        tv_mine_center.setOnClickListener(this);
        tv_shopping_cart.setOnClickListener(this);
        tv_collect.setOnClickListener(this);
        rl_search.setOnClickListener(this);
        addView(childView,LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.tv_mine_center://用户中心1
                 intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra ("position",1);
                getContext().startActivity(intent);
                break;
            case R.id.tv_shopping_cart://购物车
                 intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("position",2);
                getContext().startActivity(intent);
                break;
            case R.id.tv_collect:
                intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("position",3);
                getContext().startActivity(intent);
                break;
            case R.id.rl_search:
                intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("position",4);
                getContext().startActivity(intent);
                break;


        }
    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onMainTimeEvent(TimeEvent time) {
        if (tv_time != null) {
            tv_time.setText(time.getTime());
        }
    }

    public void clearRegister(){
        EventBus.getDefault().unregister(this);
    }
}
