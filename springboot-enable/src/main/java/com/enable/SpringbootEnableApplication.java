package com.enable;

import com.enable.demo.api.User;
import com.enable.redislock.anno.EnableDistributedLock;
import com.enable.redislock.aop.RedisLockAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan({"com.enable.demo","com.enable.redislock"})
@SpringBootApplication
@Import(User.class)
@EnableDistributedLock
public class SpringbootEnableApplication {

    public static void main(String[] args)  {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

//        User bean = context.getBean(User.class);
        RedisLockAop bean = context.getBean(RedisLockAop.class);
        System.out.println(bean);

//        Map<String, User> beansOfType = context.getBeansOfType(User.class);
//        System.out.println("start");
//        User user = beansOfType.get("user");
//        System.out.println(user);
//        System.out.println("end");
//        context.close();

    }

}
