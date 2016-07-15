package com.wckj.gfsj.Application;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.WindowManager;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.wckj.gfsj.Utils.OwerToastShow;

public class AppApplication extends Application {
    public ArrayList<Activity> activities = new ArrayList<Activity>();


    public static int mainTid;
    public static Handler handler;
    public static Context context;// 全局context
    // 屏幕的宽度
    public static int screenWidth;
    // 屏幕的高度
    public int screenHight;

    /**
     * 数据传递容器 使用过后请remove(key);
     */
    public SparseArray<Object> dataPassMap = new SparseArray<Object>();

    @Override
    public void onCreate() {
        // 防止被系统字体改变默认得字体大小
        Resources resource = getResources();
        Configuration c = resource.getConfiguration();
        c.fontScale = 1.0f;
        resource.updateConfiguration(c, resource.getDisplayMetrics());

        getLoginAction();// 获取初始登陆信息

        if (!Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            OwerToastShow.show(this, "SD卡加载异常！");
        }
        initWidthAndHeight();
        initUi();
        super.onCreate();
        initImageLoader(getApplicationContext());
    }
    public  void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context,
                "/com.clickku/images/");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .memoryCacheExtraOptions(480, 800)
                // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)
                // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                // 将保存的时候的URI名称用MD5
                // 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                // implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                // 内存缓存的最大值
                .diskCacheSize(100 * 1024 * 1024)
                // 50 Mb sd卡(本地)缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // 由原先的discCache -> diskCache
                .diskCache(new UnlimitedDiskCache(cacheDir))
                // 自定义缓存路径
                .imageDownloader(
                        new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
//				.writeDebugLogs() // Remove for release app
                // .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build();
        // 全局初始化此配置


        ImageLoader.getInstance().init(config);
    }
    /**
     * 获取用户的登录情况
     */
    private void getLoginAction() {

    }


    /**
     * 获取屏幕长度高度
     */
    private void initWidthAndHeight() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        screenWidth = outMetrics.widthPixels;
        screenHight = outMetrics.heightPixels;
    }







    /**
     * 全局handler
     */
    private void initUi() {
        mainTid = android.os.Process.myTid();
        handler = new Handler();
        context = getApplicationContext();
    }


    /**
     * 退出程序时调用
     */
    public void exitActivity() {
        for (Activity activity : activities) {
            if (activity != null)
                activity.finish();
        }
        activities.clear();
    }

    /**
     * 移除当前
     */
    public void finishActivity(Activity activity) {
        boolean b = activities.contains(activity);
        if (b)
            activities.remove(activity);
    }
}
