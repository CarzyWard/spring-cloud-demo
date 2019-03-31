package com.zzwy.service;

import com.zzwy.domain.User;

/**
 * 用户表service
 *
 * @author zhongsy
 * @date 2019/3/29
 */
public interface UserService extends BaseService<User> {
    /**
     * 完善个人信息
     * @param user 用户信息
     */
    void completer(User user);
}
