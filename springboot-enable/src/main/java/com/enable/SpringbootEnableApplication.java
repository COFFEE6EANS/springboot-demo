package com.enable;

import com.enable.annotation.EnableUser;
import com.enable.api.User;
import com.enable.async.AsyncClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;

@SpringBootApplication
@EnableAsync
//@Import(User.class)
@EnableUser
public class SpringbootEnableApplication {

    public static void main(String[] args)  {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);
        /*
        Runnable bean = context.getBean(Runnable.class);
        System.out.println(bean);
        */
        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        System.out.println("start");
        User user = beansOfType.get("user");
        System.out.println(user);
        System.out.println("end");
        context.close();

    }

}
