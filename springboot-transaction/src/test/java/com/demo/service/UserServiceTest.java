package com.demo.service;

import com.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/13
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    public List<User> findAll(){
        return userService.findAll();
    }

    @Test
    public void A(){
        User user = new User(2,"newTom");
        userService.A(user);
    }
    @Test
    public void B(){
        User user = new User(3,"newTom");
        userService.B(user);
    }
    @Test
    public void findById(){
        Integer id = 1;
        User user = userService.findById(id);
        Assert.assertNotNull(user);
    }
    @Test
    public void saveUser(){
        User user = new User(2,"Tom2");
        userService.saveUser(user);
    }

    public void delUser(int id){
        userService.delUser(id);
    }

    @Test
    public void updateUsernameById(){
        User user = new User(1,"Anni");
        userService.updateUsernameById(user);
    }
}
