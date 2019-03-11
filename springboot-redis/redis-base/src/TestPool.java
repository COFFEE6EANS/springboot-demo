import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/8
 * @Description：
 */
public class TestPool {
    public static void main(String[] args) throws Exception {
        JedisPool pool1 = JedisPoolUtils.getJedisPoolInstance();
        JedisPool pool2 = JedisPoolUtils.getJedisPoolInstance();

        Jedis jedis = pool1.getResource();

        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
    }

}
