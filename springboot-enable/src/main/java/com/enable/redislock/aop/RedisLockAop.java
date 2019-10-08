package com.enable.redislock.aop;

import com.enable.redislock.anno.JedisPoolUtils;
import com.enable.redislock.anno.RedisLockUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/12
 * @Description：
 */
@Aspect
public class RedisLockAop {


    private RedisLockUtil redisLockUtil = new RedisLockUtil();

    /**
     * Service层切点     用于记录错误日志
     */
    @Pointcut("@annotation(com.enable.redislock.anno.RedisLock)")
    public void point() {

    }

    //    @Before("point()")
    public void before(JoinPoint joinPoint) throws Throwable {
        //获取锁
        System.out.println("before()  before doing，want to get lock");
    }

    /**
     * asdasd
     *
     * @param joinPoint
     */
    @Around("point()")
    public void arround(ProceedingJoinPoint joinPoint) {
        //获取锁
        System.out.println("arround()  before doing，want to get lock");
        JedisPool jedisPoolInstance = JedisPoolUtils.getJedisPoolInstance();
        Jedis resource = jedisPoolInstance.getResource();
        String lock = redisLockUtil.tryGetDistributedLock(resource, "user", 1, 5);
        if (StringUtils.isEmpty(lock)) {
            JedisPoolUtils.release(resource);
            return;
        }
        //拿到锁  执行
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //释放锁
        System.out.println("arround()  after doing , release lock");
        redisLockUtil.tryreleaseDistributedLock(resource, lock);
        JedisPoolUtils.release(resource);
    }

}
