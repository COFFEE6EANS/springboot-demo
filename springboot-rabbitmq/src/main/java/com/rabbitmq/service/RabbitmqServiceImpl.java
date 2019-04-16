package com.rabbitmq.service;

import com.rabbitmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/15
 * @Description：
 */
@Slf4j
@Service
public class RabbitmqServiceImpl implements RabbitMqService,RabbitTemplate.ConfirmCallback {

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting = null ;
    @Value("${rabbitmq.queue.user}")
    private String userRouting = null ;
    /**
     * 注入由Spring Boot 自动配置的RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate = null;

    @Override
    public void sendMessage(String msg) {
        log.info("sendMessage:{}",msg);
        //设置回调
        rabbitTemplate.setConfirmCallback(this);
        //发送消息，通过msgRouting 确定队列
        rabbitTemplate.convertAndSend(msgRouting, msg) ;
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送用户消息： <" + user + ">");
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate . convertAndSend(userRouting, user) ;
    }

    /**
     *ConfirmCallback接口实现方法类
     * @param l
     * @param b
     * @throws IOException
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息成功消费: "+ s);
        } else {
            System.out.println("消息消费失败: "+ s);
        }
    }

}
