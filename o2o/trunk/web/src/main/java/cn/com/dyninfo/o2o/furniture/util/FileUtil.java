package cn.com.dyninfo.o2o.furniture.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/27.
 */
public class FileUtil {
    private static Logger log = Logger.getLogger(FileUtil.class);

    public static void setPermission(String fileName) {
        log.error("change mod for: " + fileName);
        log.error("os is: " + System.getProperty("os.name"));
        if (!System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            try {
//                File file = new File(fileName);
//                String strParentDirectory = file.getParent();
//                Runtime.getRuntime().exec("chmod 755 " + strParentDirectory);
                Runtime.getRuntime().exec("chmod 644 " + fileName);
            } catch (IOException e) {
                log.error("set permission failed", e);
            }
        }
    }

    public static void setPermissionWithDir(String fileName) {
        log.error("change mod for: " + fileName);
        log.error("os is: " + System.getProperty("os.name"));
        if (!System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            try {
                File file = new File(fileName);
                String strParentDirectory = file.getParent();
                log.error("Parent is: " + strParentDirectory);
                Runtime.getRuntime().exec("chmod 755 " + strParentDirectory);
                Runtime.getRuntime().exec("chmod 644 " + fileName);
            } catch (IOException e) {
                log.error("set permission failed", e);
            }
        }
    }
}
