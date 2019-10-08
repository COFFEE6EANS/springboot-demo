package com.event.service;

import com.event.entity.User;
import com.event.event.RegisterUserEvent;
import com.event.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：
 */

@Slf4j
@Service
public class RegisterService {

    @Resource
    UserMapper userMapper;

    @Autowired
    ApplicationEventPublisher publisher;
    public void saveUser(User user){
        log.info("Event---注册....");
        userMapper.saveUser(user);
        log.info("RegisterUserEvent---线程:{}---注册成功", Thread.currentThread());
        publisher.publishEvent(new RegisterUserEvent(user));
    }
}
