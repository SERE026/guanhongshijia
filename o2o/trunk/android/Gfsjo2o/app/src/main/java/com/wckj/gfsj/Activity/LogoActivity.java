package com.wckj.gfsj.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.wckj.gfsj.R;


/**
 * 公司logo页面 欢迎页面
 *acr
 */
public class LogoActivity extends Activity  {
    private int SPLASH_DISPLAY_LENGHT = 1500; // 延迟进入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_main);
        intoApplication();
    }

    /**
     * 进入引导页或者主页
     */
    public void intoApplication() {
        // 判断该应用是否第一次进入 是就进入引导页
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 开启shareSDK
                    Intent intent = new Intent(LogoActivity.this
                            ,MainActivity.class);
                    LogoActivity.this.startActivity(intent);
                    LogoActivity.this.finish();
                     overridePendingTransition(R.anim.zoom_enter,
                     R.anim.zoom_exit);
                }
            }, SPLASH_DISPLAY_LENGHT);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return false;
    }

}
