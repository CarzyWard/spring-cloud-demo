package com.zzwy.common;

/**
 * 常量
 *
 * @author zzwy
 * @date 2019/3/31
 */
public class Const {

    public static int SIGN_BONUS = 1;

    /**
     * 事件动作 BUY兑换  SIGN签到  CONTRIBUTE投稿  FORWARD转发
     */
    public interface BonusEvent {
        String BUY = "BUY";
        String SIGN = "SIGN";
        String CONTRIBUTE = "CONTRIBUTE";
        String FORWARD = "FORWARD";
    }
}
