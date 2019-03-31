package com.zzwy.common;

import java.util.UUID;

/**
 * uuid工具类
 *
 * @author zhongsy
 * @date 2018/11/12
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
