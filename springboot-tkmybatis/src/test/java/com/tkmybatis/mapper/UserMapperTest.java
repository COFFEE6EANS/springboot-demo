package com.tkmybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.tkmybatis.SpringbootTkmybatisApplicationTests;
import com.tkmybatis.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/23
 * @Description：
 */
public class UserMapperTest extends SpringbootTkmybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("username", "%红%").orEqualTo("id", "23");
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
    }

    @Test
    public void test2() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(37));
        int i = userMapper.deleteByExample(example);
        System.out.println(i);
    }
    @Test
    public void test3() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            User user = new User();
            user.setUsername("user"+i);
            user.setPassword("user"+i);
            users.add(user);
        }
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("pwd");
//        userMapper.insert(user);
        int i = userMapper.insertList(users);
        System.out.println(i);
    }    @Test
    public void test4() {
        PageHelper.startPage(1,10);
        List<User> users = userMapper.selectAll();
        System.out.println(users.size());
    }

}

