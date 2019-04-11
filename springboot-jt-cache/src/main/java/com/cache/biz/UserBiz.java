package com.cache.biz;

import com.cache.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/4/11
 * @Description：
 */
@Slf4j
@Component
public class UserBiz {

    /**
     * 模拟数据库
     */
    private static ConcurrentHashMap<Integer, User> userdata = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        Date date = new Date();
        userdata.put(1, new User(1, "tom", date));
        userdata.put(2, new User(2, "jerry", date));
        userdata.put(3, new User(3, "jack", date));
    }

    public User getUser(Integer id) {
        log.info("{} exec  UserBiz#getUser({})...", Thread.currentThread().getName(),id);
        return userdata.get(id);
    }

    public List<User> getAllUser() {
        log.info("{} exec  UserBiz#getAllUser()...", Thread.currentThread().getName());
        return userdata.values().stream().collect(Collectors.toList());
    }

    public List<User> getUserByIds(Integer id1, Integer id2) {
        log.info("{} exec  UserBiz#getUserByIds({},{})...", Thread.currentThread().getName(),id1,id2);
        return Arrays.asList(userdata.get(id1),userdata.get(id2));
    }
}
