package com.zzwy.service;

import com.zzwy.domain.BonusLog;

import java.util.List;

/**
 * 积分流水
 *
 * @author zhongsy
 * @date 2019/3/29
 */
public interface BonusLogService extends BaseService<BonusLog> {

    /**
     * 检查当天用户是否进行积分签到
     * true 已经签到 false 未签到
     */
    boolean checkSign();

    /**
     * 签到流水
     */
    void signBonusLog();

    List<BonusLog> pageBonusLog(int pageNo, int size, BonusLog bonusLog);
}
