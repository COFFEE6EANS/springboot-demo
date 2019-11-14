package test1;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/8
 * @Description：
 */
public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.33.101",6379);
        System.out.println(jedis.ping());
        jedis.set("k1","v1");
        jedis.set("count","100");
        jedis.decr("count");
        Set<String> keys = jedis.keys("*");
        keys.forEach(key-> System.out.println(key));
        System.out.println(jedis.get("count"));
    }
}
