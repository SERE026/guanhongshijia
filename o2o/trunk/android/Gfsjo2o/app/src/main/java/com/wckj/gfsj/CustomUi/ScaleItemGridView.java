package com.wckj.gfsj.CustomUi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ScaleItemGridView extends GridView {

    public ScaleItemGridView(Context context) {
        super(context);
    }

    public ScaleItemGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setChildrenDrawingOrderEnabled(true);
    }

    @SuppressLint("NewApi")
    @Override
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        super.setChildrenDrawingOrderEnabled(enabled);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        int position = getSelectedItemPosition() - getFirstVisiblePosition();
        if (position < 0) {
            return i;
        } else {
            if (i == childCount - 1) {//这是最后一个需要刷新的item
                if (position > i) {
                    position = i;
                }
                return position;
            }
            if (i == position) {//这是原本要在最后一个刷新的item
                return childCount - 1;
            }
        }
        return i;
    }
}