package com.demo.service;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/3/13
 * @Description：
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     *  a方法加了事务注解。b方法没加
     * @param newUser
     */
    @Transactional(rollbackFor = Exception.class)
    public void A(User newUser){
        //手动报异常
        updateUsernameById(newUser);
        int i = 1 / 0;
    }

    public void B(User newUser){
        //手动报异常
        saveUser(newUser);
        int i = 1 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveUser(User user){
        userMapper.save(user);
    }
    public void updateUsernameById(User user){
        userMapper.updateUsernameByid(user);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public void delUser(int id){
        userMapper.delUserById(id);
    }


}
