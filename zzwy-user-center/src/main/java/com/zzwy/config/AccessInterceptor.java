package com.zzwy.config;

import com.alibaba.fastjson.JSON;
import com.zzwy.common.CodeMsg;
import com.zzwy.common.Result;
import com.zzwy.common.ThreadContext;
import com.zzwy.domain.User;
import com.zzwy.redis.RedisService;
import com.zzwy.redis.TokenKey;
import com.zzwy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


/**
 * 拦截器-判断用户是否登录
 *
 * @author zhongsy
 * @date 2018/11/17
 */
@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        /*获取用户信息*/
        User user = getUser(request, response);

        /*将用户信息放在线程中*/
        ThreadContext.setUser(user);

        //需要登录，但用户获取失败
        if (user == null) {
            render(response, CodeMsg.SESSION_ERROR);
            return false;
        }

        return true;
    }

    private void render(HttpServletResponse response, CodeMsg codeMsg) throws Exception {
        OutputStream out = response.getOutputStream();

        //Content-Type: application/json;charset=UTF-8
        response.addHeader("Content-Type", "application/json;charset=UTF-8");

        String str = JSON.toJSONString(Result.error(codeMsg));
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

    private User getUser(HttpServletRequest request, HttpServletResponse response) {
        String paramToken = request.getParameter(TokenKey.COOKIE_NAME_TOKEN);
        String cookieToken = getCookieValue(request, TokenKey.COOKIE_NAME_TOKEN);

        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return null;
        }

        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;

        //设置token值
        ThreadContext.setToken(token);

        User user = redisService.get(TokenKey.token, token, User.class);
        if (user != null) {
            //获取用户信息不为空，重新设置token ttl失效时间
            Boolean flag = redisService.expire(TokenKey.token, token);
            if (flag == null && flag == false) {
                return null;
            }
        }

        return user;
    }

    /**
     * 遍历cookie获取token值
     */
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }

        return null;
    }
}
