package com.zzwy.controller;

import com.zzwy.common.Result;
import com.zzwy.common.ThreadContext;
import com.zzwy.domain.User;
import com.zzwy.service.UserService;
import com.zzwy.vo.CompleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层
 *
 * @author zzwy
 * @date 2019/3/29
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 完善个人信息
     */
    @PostMapping("/complete")
    @ResponseBody
    public Result<User> complete(@RequestBody CompleteRequest request) {
        //获取当前用户信息
        User user = ThreadContext.getUser();

        //赋值用户信息
        user.setNickName(request.getNickName());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        //更新用户数据
        userService.completer(user);

        return Result.success(user);
    }

    /**
     * 当前用户详细信息
     */
    @PostMapping("/me")
    @ResponseBody
    public Result<User> me() {
        return Result.success(ThreadContext.getUser());
    }
}
