package com.cache.service;

import com.cache.entity.User;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/11
 * @Description：
 */
public interface UserService {
    public User getUser(Integer id);
    public List<User> getAllUser();
    public List<User> getUserByIds(Integer id1,Integer id2);
}
