package com.zzwy.vo;

/**
 * 登录请求实体类
 *
 * @author zzwy
 * @date 2019/3/30
 */
public class LoginRequest {
    /**
     * 登录时获取的 code
     */
    private String code;
    /**
     * 昵称
     */
    private String wxNickname;
    /**
     * 头像访问路径
     */
    private String avatarUrl;
    /**
     * 性别
     */
    private int gender;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "code='" + code + '\'' +
                ", wxNickname='" + wxNickname + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                '}';
    }
}
