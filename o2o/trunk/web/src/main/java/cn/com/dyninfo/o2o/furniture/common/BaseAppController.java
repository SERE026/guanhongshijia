package cn.com.dyninfo.o2o.furniture.common;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/7/30.
 */
public class BaseAppController {

    protected Logger log = Logger.getLogger(this.getClass());

    public static int SUCCESS = 0;
    public static int NO_LOGIN = 1;
    public static int NEED_DEVICE_ID = 2;
}
