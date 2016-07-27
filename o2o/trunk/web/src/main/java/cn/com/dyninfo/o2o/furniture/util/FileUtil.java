package cn.com.dyninfo.o2o.furniture.util;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/27.
 */
public class FileUtil {

    public static void setPermission(String fileName) {
        if (!System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            try {
                Runtime.getRuntime().exec("chmod 644 " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
