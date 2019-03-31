package com.zzwy.redis;

/**
 * KEY前置基础类
 *
 * @author zhongsy
 * @date 2018/11/11
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix) {
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expirDeconds() {
        //默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String clazzName = getClass().getSimpleName();
        return clazzName + ":" + prefix;
    }
}
