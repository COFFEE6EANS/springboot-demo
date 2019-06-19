package com.tkmybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/23
 * @Description：
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="tb_user")//设置数据库中表名字
public class User {
    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;


}
