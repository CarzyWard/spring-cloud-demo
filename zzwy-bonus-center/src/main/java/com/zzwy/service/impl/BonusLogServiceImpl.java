package com.zzwy.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzwy.common.Const;
import com.zzwy.common.DateUtil;
import com.zzwy.common.ThreadContext;
import com.zzwy.common.UUIDUtil;
import com.zzwy.dao.BonusLogMapper;
import com.zzwy.domain.BonusLog;
import com.zzwy.service.BonusLogService;
import com.zzwy.service.UserBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 积分流水
 *
 * @author zzwy
 * @date 2019/3/31
 */
@Service
public class BonusLogServiceImpl extends BaseServiceImpl<BonusLog> implements BonusLogService {

    @Autowired
    BonusLogMapper bonusLogMapper;

    @Autowired
    UserBonusService bonusService;

    @Override
    public boolean checkSign() {

        Map<String, String> countMap = new HashMap<>();
        countMap.put("userId", ThreadContext.getUser().getUserId());
        countMap.put("event", Const.BonusEvent.SIGN);
        countMap.put("date", DateUtil.today());

        int count = bonusLogMapper.count(countMap);

        return (count > 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signBonusLog() {

        //积分流水实体类
        BonusLog bonusLog = new BonusLog();
        bonusLog.setId(UUIDUtil.uuid());
        bonusLog.setUserId(ThreadContext.getUser().getUserId());
        bonusLog.setEvent(Const.BonusEvent.SIGN);
        bonusLog.setBonus(Const.SIGN_BONUS);

        //保存签到积分流水
        save(bonusLog);

        //添加用户积分数
        bonusService.addBouns(Const.SIGN_BONUS);
    }

    @Override
    public List<BonusLog> pageBonusLog(int pageNo, int size, BonusLog bonusLog) {
        PageHelper.startPage(pageNo, size);
        return select(bonusLog);
    }
}
