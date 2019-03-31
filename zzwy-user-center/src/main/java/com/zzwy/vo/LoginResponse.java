package com.zzwy.vo;

import com.zzwy.domain.User;

/**
 * 登录响应实体类
 *
 * @author zzwy
 * @date 2019/3/30
 */
public class LoginResponse {
    /**
     * token
     */
    private String token;
    /**
     * 用户信息
     */
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
