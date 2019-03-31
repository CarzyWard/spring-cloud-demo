package com.zzwy.redis;

/**
 * token redis key
 *
 * @author zzwy
 * @date 2019/3/30
 */
public class TokenKey extends BasePrefix {

    private static final int TOKEN_EXPIRE = 3600 * 24 * 2;
    public static final String COOKIE_NAME_TOKEN = "token";

    private TokenKey(String prefix) {
        super(prefix);
    }

    private TokenKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static TokenKey token = new TokenKey(TOKEN_EXPIRE, COOKIE_NAME_TOKEN);
}
