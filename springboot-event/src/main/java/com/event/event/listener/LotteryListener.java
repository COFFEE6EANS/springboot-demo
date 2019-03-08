package com.event.event.listener;

import com.event.entity.User;
import com.event.event.RegisterUserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：  给新用户发红包
 */
@Slf4j
@Component
@Order(2)
public class LotteryListener implements ApplicationListener<RegisterUserEvent> {

    private final static Random random = new Random();

    @Override
    public void onApplicationEvent(RegisterUserEvent sendMsgEvent) {
        log.info("LotteryListener---线程:{}---发红包ing....", Thread.currentThread());
        User user = sendMsgEvent.getUser();
        int money = random.nextInt(100);
        log.info("恭喜手机号为：{}的用户：{} 获得{}元的新用户红包...", user.getPhoneNum(),user.getUsername(),money);
    }
}
