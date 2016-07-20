package com.wckj.gfsj.Utils;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 图片加载类封装
 */
public class ImageLoaderUtil {
    private static ImageLoaderUtil instance;
    private static ImageLoader mImageLoader;

    public static ImageLoaderUtil getInstance(){
        if(instance==null){
            instance=new ImageLoaderUtil();
        }
        if(mImageLoader==null){
            mImageLoader = ImageLoader.getInstance();
        }
        return ImageLoaderUtil.instance;
    }

    private void displayImageView(String url){
//        mImageLoader.displayImage();
    }

}
