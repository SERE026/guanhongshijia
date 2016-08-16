package com.wckj.gfsj.CustomUi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止viewpage左右滑动
 */
public class StopViewPage extends DonotViewPage{
    private boolean isCanScroll = false;
    public StopViewPage(Context context) {
        super(context);
    }
    public StopViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
//        if(isCanScroll){
//            return super.onInterceptTouchEvent(arg0);
//        }else{
            //false  不能左右滑动
            return false;
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
