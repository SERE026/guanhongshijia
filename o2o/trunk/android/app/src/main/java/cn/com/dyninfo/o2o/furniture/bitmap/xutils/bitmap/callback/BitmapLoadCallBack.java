/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.bitmap.xutils.bitmap.callback;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import cn.com.dyninfo.o2o.furniture.bitmap.xutils.bitmap.BitmapDisplayConfig;

public abstract class BitmapLoadCallBack<T extends View> {

    /**
     * Call back when start loading.
     *
     * @param container
     * @param uri
     * @param config
     */
    public void onPreLoad(T container, String uri, BitmapDisplayConfig config) {
    }

    /**
     * Call back when start loading.
     *
     * @param container
     * @param uri
     * @param config
     */
    public void onLoadStarted(T container, String uri, BitmapDisplayConfig config) {
    }

    /**
     * Call back when loading.
     *
     * @param container
     * @param uri
     * @param config
     * @param total
     * @param current
     */
    public void onLoading(T container, String uri, BitmapDisplayConfig config, long total, long current) {
    }

    /**
     * Call back when bitmap has loaded.
     *
     * @param container
     * @param uri
     * @param bitmap
     * @param config
     */
    public abstract void onLoadCompleted(T container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from);

    /**
     * Call back when bitmap failed to load.
     *
     * @param container
     * @param uri
     * @param drawable
     */
    public abstract void onLoadFailed(T container, String uri, Drawable drawable);

    private BitmapSetter<T> bitmapSetter;

    public void setBitmapSetter(BitmapSetter<T> bitmapSetter) {
        this.bitmapSetter = bitmapSetter;
    }

    public void setBitmap(T container, Bitmap bitmap) {
        if (bitmapSetter != null) {
            bitmapSetter.setBitmap(container, bitmap);
        } else if (container instanceof ImageView) {
//            ((ImageView) container).setImageBitmap(bitmap);
            ((ImageView) container).setImageBitmap(bitmap);
        } else {
            container.setBackgroundDrawable(new BitmapDrawable(container.getResources(), bitmap));
        }
    }

    public void setDrawable(T container, Drawable drawable) {
        if (bitmapSetter != null) {
            bitmapSetter.setDrawable(container, drawable);
        } else if (container instanceof ImageView) {
            ((ImageView) container).setImageDrawable(drawable);
        } else {
            container.setBackgroundDrawable(drawable);
        }
    }

    public Drawable getDrawable(T container) {
        if (bitmapSetter != null) {
            return bitmapSetter.getDrawable(container);
        } else if (container instanceof ImageView) {
            return ((ImageView) container).getDrawable();
        } else {
            return container.getBackground();
        }
    }
}
