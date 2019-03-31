package com.zzwy.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 封装StringRedisTemplate
 *
 * @author zzwy
 * @date 2019/3/30
 */
@Service
public class RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 获取当个对象
     */
    public <T> T get(BasePrefix basePrefix, String key, Class<T> clazz) {
        String str = redisTemplate.opsForValue().get(basePrefix.getPrefix() + key);
        T t = stringToBean(str, clazz);
        return t;
    }

    /**
     * 设置对象
     */
    public <T> boolean set(BasePrefix basePrefix, String key, T value) {

        String str = beanToString(value);
        if (str == null || str.length() <= 0) {
            return false;
        }

        String readKey = basePrefix.getPrefix() + key;

        int seconds = basePrefix.expirDeconds();
        if (seconds <= 0) {
            redisTemplate.opsForValue().set(readKey, str);
        } else {
            redisTemplate.opsForValue().set(readKey, str, seconds, TimeUnit.SECONDS);
        }

        return true;
    }

    /**
     * 设置过期时间
     */
    public Boolean expire(BasePrefix basePrefix, String key) {
        return redisTemplate.expire(basePrefix.getPrefix() + key, basePrefix.expirDeconds(), TimeUnit.SECONDS);
    }

    /**
     * 判断是否存在
     */
    public Boolean exists(BasePrefix basePrefix, String key) {
        return redisTemplate.hasKey(basePrefix.getPrefix() + key);
    }

    /**
     * 删除
     */
    public Boolean delete(BasePrefix basePrefix, String key) {
        return redisTemplate.delete(basePrefix.getPrefix() + key);
    }

    /**
     * Bean转成字符串
     */
    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }

        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * 字符串转成Bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}
