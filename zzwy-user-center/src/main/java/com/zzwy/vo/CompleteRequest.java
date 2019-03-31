package com.zzwy.vo;

/**
 * 完善个人信息请求实体类
 *
 * @author zzwy
 * @date 2019/3/31
 */
public class CompleteRequest {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
