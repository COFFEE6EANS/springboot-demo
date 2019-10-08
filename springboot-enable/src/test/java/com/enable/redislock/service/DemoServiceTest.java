package com.enable.redislock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/13
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    public void doSomething(){
        for (int i=0;i<1;i++){
//            new Thread(()->{
                demoService.doSomething();
//            }).start();
        }
    }
}
