package test1;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/8
 * @Description：
 */
public class TestMS {
    public static void main(String[] args) {
        Jedis jedisM = new Jedis("192.168.33.101",6380);
        Jedis jedisS = new Jedis("192.168.33.101",6381);
        jedisS.slaveof("192.168.33.101",6380);
        jedisM.set("k1","v1");
        jedisM.set("count","100");
        Set<String> keys = jedisS.keys("*");
        keys.forEach(key->{
            System.out.println(key);
        });
    }
}
