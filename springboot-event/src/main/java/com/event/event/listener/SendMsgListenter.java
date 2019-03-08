package com.event.event.listener;

import com.event.entity.User;
import com.event.event.RegisterUserEvent;
import com.event.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：  提醒用户注册成功
 */
@Slf4j
@Component
@Order(0)
public class SendMsgListenter implements ApplicationListener<RegisterUserEvent> {

    @Override
    public void onApplicationEvent(RegisterUserEvent sendMsgEvent) {
        log.info("SendMsgListenter---线程:{}---提示注册成功ing....", Thread.currentThread());
        User user = sendMsgEvent.getUser();
        log.info("恭喜手机号为：{}的用户：{} 注册成功...", user.getPhoneNum(),user.getUsername());
    }
}
