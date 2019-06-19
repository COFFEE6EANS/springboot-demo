package com.tkmybatis.service.impl;

import com.tkmybatis.SpringbootTkmybatisApplicationTests;
import com.tkmybatis.entity.User;
import com.tkmybatis.mapper.UserMapper;
import com.tkmybatis.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/23
 * @Description：
 */
public class UserServiceImplTest extends SpringbootTkmybatisApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void testGetUserList(){
        List<User> userList = userService.getUserList();
        System.out.println(userList);
    }

}
