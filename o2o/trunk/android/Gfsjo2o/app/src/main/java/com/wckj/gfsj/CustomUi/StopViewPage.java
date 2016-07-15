package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止viewpage左右滑动
 */
public class StopViewPage extends ViewPager{
    private boolean isCanScroll = false;
    public StopViewPage(Context context) {
        super(context);
    }
    public StopViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if(isCanScroll){
            return super.onInterceptTouchEvent(arg0);
        }else{
            //false  不能左右滑动
            return false;
        }
    }

}
