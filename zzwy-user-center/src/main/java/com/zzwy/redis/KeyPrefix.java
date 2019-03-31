package com.zzwy.redis;

/**
 * Key的前缀
 *
 * @author zhongsy
 * @date 2018/11/11
 */
public interface KeyPrefix {
    int expirDeconds();

    String getPrefix();
}
