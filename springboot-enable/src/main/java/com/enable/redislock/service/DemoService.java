package com.enable.redislock.service;

import com.enable.redislock.anno.RedisLock;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/12
 * @Description：
 */
@Service
public class DemoService {

    @RedisLock
    public String doSomething(){
        System.out.println("do ing ...");
        return "success";
    }
}
