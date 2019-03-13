package com.enable.redislock.anno;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

    private static final String ip = "127.0.0.1";
    private static final int port = 6379;
    private static JedisPool jedisPool = null;

    private JedisPoolUtils(){};

    public static JedisPool getJedisPoolInstance(){
        if (jedisPool == null){
            synchronized (JedisPoolUtils.class){
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(1000);
                config.setMaxIdle(32);
                config.setMaxWaitMillis(100*1000);
                config.setTestOnBorrow(true);
                jedisPool = new JedisPool(config,ip,port);
            }
        }
        return jedisPool;
    }

    /**
     * 释放连接
     * @param jedis
     */
    public static void release(Jedis jedis) {
        if(null != jedis) {
            jedis.close();
        }
    }
}
