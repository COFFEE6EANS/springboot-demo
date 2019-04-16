package com.rabbitmq.web;

import com.rabbitmq.entity.User;
import com.rabbitmq.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/16
 * @Description：
 */
@RequestMapping("/rabbitmq")
@RestController
public class RabbitMQController {

    @Autowired
    RabbitMqService rabbitMqService;

    @GetMapping("/msg")
    public Map<String,Object> msg(String msg){
        rabbitMqService.sendMessage(msg);
        return resultMap("message",msg);
    }
    @GetMapping("/user")
    public Map<String,Object> user(String id,String username){
        System.out.println("/user exec ....");
        User user = new User(id,username);
        rabbitMqService.sendUser(user);
        return resultMap("user:",user);
    }
    private Map<String , Object> resultMap(String key , Object obj) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put(key, obj);
        return result;
    }
}
