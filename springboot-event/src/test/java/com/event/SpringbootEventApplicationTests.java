package com.event;

import com.event.entity.User;
import com.event.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEventApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    RegisterService registerService;
    @Test
    public void register() {
        User user = new User();
        user.setId("1").setPhoneNum("110").setUsername("警察同志");
        registerService.saveUser(user);
    }
}

