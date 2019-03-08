package com.event.mapper;

import com.event.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：
 */
@Repository
public class UserMapper {

    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public void saveUser(User user){
        userMap.put(user.getId(),user);
    }
}
