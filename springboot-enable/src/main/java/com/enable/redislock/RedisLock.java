package com.enable.redislock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/1
 * @Description：
 */
public class RedisLock {

    private final static String REDISKEY = "REDISKEY";
    private JedisPool jedisPool;

    public  static boolean tryGetDistributedLock(Jedis jedis, String lockKeyPrefix, int connectTime, int expireTime) {
        String redisValue = lockKeyPrefix+":"+UUID.randomUUID().toString();
        long currentTime = System.currentTimeMillis();
        while (currentTime < currentTime+connectTime){
            String s = jedis.get(REDISKEY);
        }
        return false;
    }

}
