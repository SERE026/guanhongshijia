package com.wckj.gfsj.Utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wckj.gfsj.R;

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

    public void displayImageView(String url, ImageView imageAware){
        mImageLoader.displayImage(url,imageAware,getPictrueOption(R.drawable.icon_public_image));
    }

    /**
     * 默认配置
     */
    public DisplayImageOptions getPictrueOption(int res) {
        DisplayImageOptions options;
        options = new DisplayImageOptions.Builder().showImageOnLoading(res) // 设置图片在下载期间显示的图片
                .showImageForEmptyUri(res)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(res) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
                // 设置图片加入缓存前，对bitmap进行设置
                // .preProcessor(BitmapProcessor preProcessor)
                .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
//				.delayBeforeLoading(50)//载入图片前稍做延时可以提高整体滑动的流畅度
//				 .displayer(new SimpleBitmapDisplayer())//是否图片加载好后渐入的动画时间
                .build();
        return options;
    }
}
