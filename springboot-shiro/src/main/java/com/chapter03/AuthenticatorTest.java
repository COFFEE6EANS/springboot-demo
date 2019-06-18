package com.chapter03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AuthenticatorTest {

    public void login(String configFile,String username,String pwd) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory(configFile);
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        subject.login(token);
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess() {
        login("classpath:shiro-role.ini","zhang","123");
        Subject subject = SecurityUtils.getSubject();
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        Assert.assertTrue(subject.hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }

    @Test
    public void testCheckRole() {
        login("classpath:shiro-role.ini","zhang","123");
        Subject subject = SecurityUtils.getSubject();
        //断言拥有角色：role1
        subject.checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject.checkRoles("role1", "role2");
    }

    @Test
    public void testIsPermitted() {
        login("classpath:shiro-role.ini", "wang", "123");
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("user:create");
//        subject.checkPermissions("user:create","user:delete","user:update");
    }
    @Test
    public void testIsPermitted1() {
        login("classpath:shiro-role.ini", "li", "123");
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermissions("system:user:create","system:user:delete");
        subject.checkPermissions("system:user:create,delete");
    }
    @Test
    public void testIsPermitted2() {
        login("classpath:shiro-role.ini", "zhao", "123");
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermissions("system:user:create","system:user:delete");
        subject.checkPermissions("system:user:create,delete");
    }
    @Test
    public void testIsPermitted3() {
        login("classpath:shiro-role.ini", "aaa", "123");
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermissions("system:user:create","system:user:delete");
        subject.checkPermissions("system:user:create,query,hahahah,delete");

    }
}
