package test1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/8
 * @Description：
 */
public class JedisPoolUtils {

    private static final String ip = "192.168.33.101";
    private static final int port = 6379;
    private static JedisPool jedisPool = null;

    private JedisPoolUtils(){};

    public static JedisPool getJedisPoolInstance(){
        if (jedisPool == null){
            synchronized (JedisPoolUtils.class){
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxActive(1000);
                config.setMaxIdle(32);
                config.setMaxWait(100*1000);
                config.setTestOnBorrow(true);
                jedisPool = new JedisPool(config,ip,port);
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool,Jedis jedis){
        if (null != jedis){
            jedisPool.returnResource(jedis);
        }
    }
}
