package com.rabbitmq.service;

import com.rabbitmq.entity.User;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/15
 * @Description：
 */
public interface RabbitMqService {

    /**
     *  发送字符串消息
     * @param msg
     */
    public void sendMessage(String msg);

    /**
     *  发送用户信息
     * @param user
     */
    public void sendUser(User user);
}
