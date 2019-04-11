package com.cache.web;

import com.cache.entity.User;
import com.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/11
 * @Description：
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
    @GetMapping("/getAllUser")
    public List<User> getUser(){
        return userService.getAllUser();
    }
    @GetMapping("/getUserByIds")
    public List<User> getUserByIds(@RequestParam Integer id1,@RequestParam Integer id2){
        System.out.println("getUserByIds");
        return userService.getUserByIds(id1,id2);
    }
}
