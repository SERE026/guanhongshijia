package com.wckj.gfsj.Utils;


import com.wckj.gfsj.Application.AppApplication;

import java.io.IOException;
import java.util.Properties;

/**
 * @author acr
 * @文件描述: 工厂类
 */
public class ClassFactory {

    // 依据配置文件加载实例
    private static ClassFactory factory = new ClassFactory();

    private ClassFactory() {
        // 私有化
    }

    public static ClassFactory getFactory() {
        return factory;
    }


    private static Properties properties;

    static {
        properties = new Properties();

        // bean.properties必须在src的跟目录下
        try {
            LogUtil.d("++++" + AppApplication.context.getResources().getAssets().open("bean.properties"));
            properties.load(AppApplication.context.getResources().getAssets().open("clazz.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载需要的实现类
     *
     * @param clazz
     * @return
     */
    public static <T> T getInstance(Class<T> clazz) {
        String key = clazz.getSimpleName();//clazz.getName()
        String className = properties.getProperty(key);
        try {
            return (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
