package cn.com.sabs.mem.utils;

import java.util.UUID;

/**
 * @ClassName
 * @Description TODO
 * @Author Tony
 * @Date 2020/12/20 22:03
 * Version 1.0
 */
public class UuidUtils {
    public static String getUUid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
