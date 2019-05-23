package com.base.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/13
 * @Description：
 */
@Data
public class UserVo {

    private String name;
    private Date birthday;
    private Integer age;
}
