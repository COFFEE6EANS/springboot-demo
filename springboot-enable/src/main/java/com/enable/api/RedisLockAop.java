package com.enable.api;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
public class RedisLockAop {

    @Pointcut("@annotation(com.enable.annotation.RedisLock)")
    public void pointcut(){

    }
    @Around("pointcut()")
    public void around(){

    }

}
