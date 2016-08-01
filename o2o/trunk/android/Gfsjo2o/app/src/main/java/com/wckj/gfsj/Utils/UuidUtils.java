package com.wckj.gfsj.Utils;

import java.util.UUID;

/**
 * 生成唯一码
 */
public class UuidUtils {
    public static String  getUuid(){
       return UUID.randomUUID().toString();
    }
}
