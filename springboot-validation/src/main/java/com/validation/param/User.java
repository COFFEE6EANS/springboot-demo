package com.validation.param;

import lombok.Data;

/**
 * @author guojianfeng.
 * @date created in  2019/8/22
 * @desc
 */
@Data
public class User {
    private String name;
    private Integer age;
    private Pet pet;
}
@Data
class Pet{
    private String type;
    private String petName;
}