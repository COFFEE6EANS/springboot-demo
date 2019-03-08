package com.event.rest;

import com.event.entity.User;
import com.event.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：
 */
@RestController
public class UserController {

    @Autowired
    RegisterService registerService;

    @PostMapping("register")
    public String register(@RequestBody User user){
        registerService.saveUser(user);
        return "success";
    }
}
