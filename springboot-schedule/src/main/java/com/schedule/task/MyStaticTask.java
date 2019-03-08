package com.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.function.Function;

/**
 * @ Author     ：guojianfeng.
 * @ Date       ：Created in 15:57 2018/9/19
 * @ Description：${description}
 */
@Component
public class MyStaticTask {

    /**
     * fixedRate：定义一个按一定频率执行的定时任务
     * fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。
     * cron：通过表达式来配置任务执行时间
     */
    /**
     * 秒（0~59）
     * 分钟（0~59）
     * 3 小时（0~23）
     * 4 天（0~31）
     * 5 月（0~11）
     * 6 星期（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 年份（1970－2099）
     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void doTask(){
//        System.out.println("=====>>>>>使用cron  "+LocalDateTime.now());
//    }
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        System.out.println("=====>>>>>使用fixedRate  "+ LocalDateTime.now());
//    }
    //@Scheduled(fixedDelay = 5000,initialDelay = 1l)
    public void scheduled2() {
        System.out.println("=====>>>>>fixedDelay  "+ LocalDateTime.now());
    }
}
