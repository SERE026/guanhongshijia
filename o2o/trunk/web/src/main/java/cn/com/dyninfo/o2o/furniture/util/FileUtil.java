package cn.com.dyninfo.o2o.furniture.util;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/27.
 */
public class FileUtil {
    private static Logger log = Logger.getLogger(FileUtil.class);

    public static void setPermission(String fileName) {
        log.error("change mod for: " + fileName);
        if (!System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            try {
                Runtime.getRuntime().exec("chmod 644 " + fileName);
            } catch (IOException e) {
                log.error("set permission failed", e);
            }
        }
    }
}
