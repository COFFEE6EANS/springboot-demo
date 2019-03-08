package com.event.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/1/29
 * @Description：
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;
    private String phoneNum;
    private String username;
}
