package com.enable.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/8
 * @Description：
 */
@Component
public class AsyncClass implements Runnable{

    @Override
    @Async
    public void run() {
        for (int i=0;i<10;i++){
            if ( Thread.currentThread().isInterrupted() ) {
                System.out.println("i has interputed");
            }
            System.out.println("i:"+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
