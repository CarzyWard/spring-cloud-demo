package com.zzwy.controller;

import com.zzwy.common.CodeMsg;
import com.zzwy.common.Result;
import com.zzwy.common.UUIDUtil;
import com.zzwy.domain.User;
import com.zzwy.redis.RedisService;
import com.zzwy.redis.TokenKey;
import com.zzwy.service.UserService;
import com.zzwy.vo.LoginRequest;
import com.zzwy.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户登录
 *
 * @author zzwy
 * @date 2019/3/30
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    /**
     * 登录
     */
    @PostMapping("miniapp")
    @ResponseBody
    public Result<LoginResponse> miniapp(@RequestBody LoginRequest request) {

        /*1、根据请求参数中code，向微信发起请求，获取用户信息，比如openid等，暂时不做*/

        /*2、根据openid，查询用户信息，目前认为code即为用户主键id，直接查询数据库*/
        User user = userService.selectByKey(request.getCode());
        if (user == null) {
            return Result.error(CodeMsg.INVALID_USER);
        }

        /*3、生成token，并将用户信息更新到redis，其他系统直接访问redis获取用户信息*/
        String token = UUIDUtil.uuid();
        redisService.set(TokenKey.token, token, user);

        /*4、组织响应报文*/
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUser(user);

        return Result.success(response);
    }
}
