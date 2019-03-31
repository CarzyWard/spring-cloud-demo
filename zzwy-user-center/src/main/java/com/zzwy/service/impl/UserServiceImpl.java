package com.zzwy.service.impl;

import com.zzwy.common.DateUtil;
import com.zzwy.common.ThreadContext;
import com.zzwy.domain.User;
import com.zzwy.redis.RedisService;
import com.zzwy.redis.TokenKey;
import com.zzwy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息
 *
 * @author zhongsy
 * @date 2019/3/29
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    RedisService redisService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void completer(User user) {

        //更新时间
        user.setUpdateTime(DateUtil.curDateTime());

        //更新数据库
        updateAll(user);

        //更新token reids
        redisService.set(TokenKey.token, ThreadContext.getToken(), user);
    }
}
