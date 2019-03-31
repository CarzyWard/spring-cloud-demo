package com.zzwy.dao;

import com.zzwy.domain.UserBonus;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 用户积分
 *
 * @author zzwy
 * @date 2019/3/29
 */
public interface UserBonusrMapper extends Mapper<UserBonus> {

    /**
     * 增加积分数
     */
    void addBouns(Map map);
}
