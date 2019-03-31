package com.zzwy.service;

import com.zzwy.domain.UserBonus;

/**
 * 用户积分
 *
 * @author zhongsy
 * @date 2019/3/29
 */
public interface UserBonusService extends BaseService<UserBonus> {
    /**
     * 增加积分数
     */
    void addBouns(int bonus);
}
