package com.event.event;

import com.event.entity.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：
 */
public class RegisterUserEvent extends ApplicationEvent {

    public RegisterUserEvent(User user) {
        super(user);
    }
    public User getUser() {
        return (User) source;
    }
}
