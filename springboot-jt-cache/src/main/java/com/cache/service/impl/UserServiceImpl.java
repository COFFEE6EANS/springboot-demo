package com.cache.service.impl;

import com.cache.biz.UserBiz;
import com.cache.entity.User;
import com.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/11
 * @Description：
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBiz userBiz;
    /**
     *  调用getUser方法前 会调用缓存管理器 取得名为“user”的缓存，缓存项Key就是方法参数id,
     *  如果缓存命中 返回此值 如果没有 调用方法 再返回结果前 将查询结果缓存以备下次使用
     * @param id
     * @return
     */
    @Cacheable(value = {"user","userExt"},cacheNames = "user",condition = "#id>1")
    @Override
    public User getUser(Integer id) {
        log.info("{} exec  UserServiceImpl#getUser({})...",Thread.currentThread().getName(),id);
        return userBiz.getUser(id);
    }

    /**
     *  无参
     * @return
     */
    @Cacheable(value = "allUser",cacheNames = "user")
    @Override
    public List<User> getAllUser(){
        log.info("{} exec  UserServiceImpl#getAllUser()...",Thread.currentThread().getName());
        return userBiz.getAllUser();
    }

    /**
     *  多参
     * @param id1
     * @param id2
     * @return
     */
    @Cacheable(value = "many_users",cacheNames = "user")
    @Override
    public List<User> getUserByIds(Integer id1,Integer id2){
        log.info("{} exec  UserServiceImpl#getUserByIds({},{})...",Thread.currentThread().getName(),id1,id2);
        return userBiz.getUserByIds(id1,id2);
    }
}
