package com.wckj.gfsj.Application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.wckj.gfsj.Bean.LoginResult;
import com.wckj.gfsj.Db.JsonDao;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.Utils.LogUtil;
import com.wckj.gfsj.Utils.UuidUtils;
import com.xsj.crasheye.Crasheye;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.wckj.gfsj.Agora.BaseEngineEventHandlerActivity;
import com.wckj.gfsj.Agora.MessageHandler;
import io.agora.rtc.RtcEngine;
import okhttp3.OkHttpClient;

public class AppApplication extends Application {
    public ArrayList<Activity> activities = new ArrayList<Activity>();

    public static int mainTid;
    public static Handler handler;
    public static Context context;// 全局context
    public static  LoginResult loginResult;

    private RtcEngine rtcEngine;
    private MessageHandler messageHandler;


    @Override
    public void onCreate() {

        LogUtil.initLog(true);// 打开Log输出
        messageHandler = new MessageHandler();
        Crasheye.initWithNativeHandle(this, "06798b00");

        initWidthAndHeight();
        initUi();
        initImageLoader(getApplicationContext());
        initHttp();
        getLoginAction();// 获取初始登陆信息
        super.onCreate();
    }

    private void initHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }


    public  void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context,
                "/com.wckj.gfsj/images/");
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
     * Test vendor key:  6D7A26A1D3554A54A9F43BE6797FE3E2
     * @param vendorKey
     */
    public void setRtcEngine(String vendorKey){

        if(rtcEngine==null) {
            rtcEngine = RtcEngine.create(getApplicationContext(), "d758a169a5b84dba8f89d1364e98b475", messageHandler);
        }
    }

    public RtcEngine getRtcEngine(){

        return rtcEngine;
    }

    public void setEngineEventHandlerActivity(BaseEngineEventHandlerActivity engineEventHandlerActivity){
        messageHandler.setActivity(engineEventHandlerActivity);
    }
    /**
     * 获取用户的登录情况
     */
    private void getLoginAction() {
        JsonDao jsonDao = new JsonDao();
        String jsonByUrl = jsonDao.getJsonByUrl(GlobalUtils.LOGIN_URL);
        if(jsonByUrl!=null){
            loginResult = JSON.parseObject(jsonByUrl, LoginResult.class);
        }else {
            loginResult = new LoginResult();
            loginResult.setDeviceId(UuidUtils.getUuid());
        }

    }


    /**
     * 获取屏幕长度高度
     */
    private void initWidthAndHeight() {
//        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
//        screenWidth = outMetrics.widthPixels;
//        screenHight = outMetrics.heightPixels;

        // 防止被系统字体改变默认得字体大小
        Resources resource = getResources();
        Configuration c = resource.getConfiguration();
        c.fontScale = 1.0f;
        resource.updateConfiguration(c, resource.getDisplayMetrics());
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
