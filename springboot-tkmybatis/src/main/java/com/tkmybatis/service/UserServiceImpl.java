package com.tkmybatis.service;

import com.tkmybatis.entity.User;
import com.tkmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/23
 * @Description：
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(){
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        String format1 = format.parse("20190101");
        return userMapper.selectAll();
    }


}
