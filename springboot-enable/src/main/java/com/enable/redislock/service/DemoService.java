package com.enable.redislock.service;

import com.enable.redislock.anno.RedisLock;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/12
 * @Description：
 */
@Service
public class DemoService {

    @RedisLock
    public String doSomething(){
        try {
            System.out.println("do ing ...");
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public static void main(String[] args) {
        final ConcurrentHashMap<String, List<String>> cache = new ConcurrentHashMap();
        LocalDate localDate = LocalDate.now().minusDays(3);
              cache.remove(localDate);
    }
}
