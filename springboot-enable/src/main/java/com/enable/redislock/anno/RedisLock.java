package com.enable.redislock.anno;


import java.lang.annotation.*;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {
}
