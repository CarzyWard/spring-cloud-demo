package com.zzwy.controller;

import com.github.pagehelper.PageInfo;
import com.zzwy.common.Result;
import com.zzwy.common.ThreadContext;
import com.zzwy.domain.BonusLog;
import com.zzwy.domain.UserBonus;
import com.zzwy.service.BonusLogService;
import com.zzwy.service.UserBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分
 *
 * @author zzwy
 * @date 2019/3/31
 */
@RestController
public class BonusControllor {

    @Autowired
    UserBonusService bonusService;

    @Autowired
    BonusLogService logService;

    /**
     * 查看用户积分信息
     */
    @ResponseBody
    @GetMapping("bonus")
    public Result<UserBonus> bonus() {

        String userId = ThreadContext.getUser().getUserId();

        return Result.success(bonusService.selectByKey(userId));
    }

    /**
     * 查看用户积分流水
     */
    @ResponseBody
    @GetMapping("bonuslog")
    public Result<PageInfo> bonuslog(@RequestParam int pageNo, @RequestParam int size) {

        String userId = ThreadContext.getUser().getUserId();
        BonusLog bonusLog = new BonusLog();
        bonusLog.setUserId(userId);

        PageInfo<BonusLog> pageInfo = new PageInfo<>(logService.pageBonusLog(pageNo, size, bonusLog));

        return Result.success(pageInfo);
    }
}
