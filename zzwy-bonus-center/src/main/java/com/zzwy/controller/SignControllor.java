package com.zzwy.controller;

import com.zzwy.common.CodeMsg;
import com.zzwy.common.Result;
import com.zzwy.service.BonusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 签到
 *
 * @author zzwy
 * @date 2019/3/31
 */
@RestController
public class SignControllor {

    @Autowired
    BonusLogService bonusLogService;

    /**
     * 签到
     */
    @ResponseBody
    @GetMapping("sign")
    public Result<Boolean> sign() {

        //1、判断用户今天是否已经签到过
        boolean isSign = bonusLogService.checkSign();
        if (isSign) {
            return Result.error(CodeMsg.CHECKED_IN);
        }

        //2、进行签到处理，记录积分流水表中以及添加用户积分数
        bonusLogService.signBonusLog();

        return Result.success(true);
    }
}
