package com.enable.redislock.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/12
 * @Description：
 */
@Aspect
public class RedisLockAop {

    /**
     * Service层切点     用于记录错误日志
     */
    @Pointcut("@annotation(com.enable.redislock.anno.RedisLock)")
    public void point() {

    }
    @Before("point()")
    public void before(JoinPoint joinPoint) throws Throwable{
        //获取锁
        System.out.println("before()  before doing，get lock");
    }

    @Around("point()")
    public void arround(ProceedingJoinPoint joinPoint){
        //获取锁
        System.out.println("arround()  before doing，get lock");
        //拿到锁  执行
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //释放锁
        System.out.println("arround()  after doing  release lock");
    }

}
