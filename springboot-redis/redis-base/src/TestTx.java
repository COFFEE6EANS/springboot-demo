import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/8
 * @Description：
 */
public class TestTx {
    public static void main(String[] args) throws Exception {
        TestTx testTx = new TestTx();
        testTx.fun2();

    }

    Jedis jedis = new Jedis("192.168.33.101", 6379);

    public boolean fun2() throws Exception {
        int myBalance;
        int youBalance;
        int cost = 10;

        jedis.watch("myBalance");
        //jedis.set("balance","5");//此句不该出现，讲课方便。模拟其他程序已经修改了该条目
        Thread.sleep(7000);
        myBalance = Integer.parseInt(jedis.get("myBalance"));
        if (myBalance < cost) {
            jedis.unwatch();
            System.out.println("modify");
            return false;
        } else {
            System.out.println("***********transaction");
            Transaction transaction = jedis.multi();
            transaction.decrBy("myBalance", cost);
            transaction.incrBy("youBalance", cost);
            transaction.exec();

            myBalance = Integer.parseInt(jedis.get("myBalance"));
            youBalance = Integer.parseInt(jedis.get("youBalance"));

            System.out.println("*******" + myBalance);
            System.out.println("*******" + youBalance);
            return true;
        }
    }

    public void fun1() {
        System.out.println(jedis.ping());
        Transaction t = jedis.multi();

        t.set("key3", "value1");
        t.set("key4", "value2");

        t.discard();
//        t.exec();
    }
}
