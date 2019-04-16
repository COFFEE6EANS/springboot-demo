package com.rabbitmq.recevice;

import com.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/15
 * @Description：
 */
@Component
public class RabbitMessageRecevicer {

    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receviceMessage(String msg){
        System.out.println("收到消息：【"+msg+"】");
    }
    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receviceUser(User user){
        System.out.println("收到用户消息：【"+user+"】");
    }
}
