package com.zzwy.common;

import com.zzwy.domain.User;

/**
 * 线程内容信息
 *
 * @author zhongsy
 * @date 2018/11/17
 */
public class ThreadContext {

    /**
     * 用户信息
     */
    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();
    /**
     * token
     */
    private static ThreadLocal<String> tokenHolder = new ThreadLocal<String>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }

    public static void setToken(String token) {
        tokenHolder.set(token);
    }

    public static String getToken() {
        return tokenHolder.get();
    }

}