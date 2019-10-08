package com.example.springbootproperty.web;

import com.example.springbootproperty.vo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guojianfeng.
 * @date created in  2019/7/30
 * @desc
 */
@RestController
public class UserController {
//    @Value("")
    List<User> users;

    @Value("strs")
    List<String> strs;
    @GetMapping("/")
    public List<User> listUsers(){
        return users;
    }
    @GetMapping("/strs")
    public List<String> liststrs(){
        return strs;
    }
}
