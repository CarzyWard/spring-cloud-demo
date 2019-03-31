package com.zzwy.service.impl;

import com.zzwy.common.ThreadContext;
import com.zzwy.dao.UserBonusrMapper;
import com.zzwy.domain.UserBonus;
import com.zzwy.service.UserBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户积分
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Service
public class UserBonusServiceImpl extends BaseServiceImpl<UserBonus> implements UserBonusService {
    @Autowired
    UserBonusrMapper bonusrMapper;

    @Override
    public void addBouns(int bonus) {

        Map<String, Object> addMap = new HashMap<>();
        addMap.put("userId", ThreadContext.getUser().getUserId());
        addMap.put("bonus", bonus);

        bonusrMapper.addBouns(addMap);
    }
}
