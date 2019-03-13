package com.enable.redislock.anno;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/1
 * @Description：
 */
@Slf4j
public class RedisLockUtil {

    private final static String REDISKEY = "REDISKEY";

    /**
     *  获取锁
     * @param jedis
     * @param connectTime
     * @param expireTime
     * @return
     */
    public synchronized String tryGetDistributedLock(Jedis jedis, String lockValuePrefix, int connectTime, int expireTime) {
//        log.info("线程{}  。。。",Thread.currentThread().getName());
        String redisValue = lockValuePrefix+":"+UUID.randomUUID().toString();
        //秒->毫秒
        connectTime = connectTime*1000;
        long currentTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < currentTime+connectTime){
            String value = jedis.get(REDISKEY);
            if (StringUtils.isEmpty(value)){
                log.info("线程{} 获取到锁 成功",Thread.currentThread().getName());
                jedis.setnx(REDISKEY,redisValue);
                jedis.expire(REDISKEY,expireTime);
                return redisValue;
            }
        }
        log.info("线程{} 获取锁失败",Thread.currentThread().getName());
        return null;
    }
    /**
     *  释放锁
     */
    public boolean tryreleaseDistributedLock(Jedis jedis, String value) {
        String redisLock = jedis.get(REDISKEY);
        if (StringUtils.equals(redisLock,value)){
            jedis.del(REDISKEY);
            log.info("线程{} 释放锁 成功",Thread.currentThread().getName());
            return true;
        }
        log.info("线程{} 释放锁 失败",Thread.currentThread().getName());
        return false;
    }

}
